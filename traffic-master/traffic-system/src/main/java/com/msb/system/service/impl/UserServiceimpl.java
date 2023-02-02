package com.msb.system.service.impl;

import com.msb.api.code.SystemCode;
import com.msb.api.commons.*;
import com.msb.system.entity.UserEntity;
import com.msb.system.info.RoleInfo;
import com.msb.system.info.TUserInfo;
import com.msb.system.repository.Rolerepositoty;
import com.msb.system.repository.Userepository;
import com.msb.system.service.UserService;
import com.msb.system.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * @author: zebin
 * @Date: 2022/11/23 - 11 - 23 - 23:15
 * @Description: com.msb.system.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceimpl implements UserService {

    final Integer USTATUS_OK = 0;
    final Integer USTATUS_DEL = 1;
    Logger logger = LoggerFactory.getLogger(UserServiceimpl.class);
    @Autowired
    Userepository userepository;
    @Autowired
    Rolerepositoty rolerepositoty;




    /**
     * 添加用户,该用户有一些角色
     * @param userEntity
     * @return
     */
    @Override
    public boolean adduser(UserEntity userEntity) {
        logger.info("UserServiceimpl adduser :" + userEntity);
        String[] strings = userEntity.getRolestr().split(",");

        List<RoleInfo> roleInfos = new ArrayList<>();
        TUserInfo tUserInfo = ConvertUtil.userEntityConvertTUserInfo(userEntity);
        if (!SystemUtils.isNull(tUserInfo)){
            for (String roleId : strings){
                if (!SystemUtils.isNull(rolerepositoty.findById(Long.parseLong(roleId)).get())) {
                    RoleInfo roleInfo = rolerepositoty.findById(Long.parseLong(roleId)).get();
                    roleInfos.add(roleInfo);
                }
            }
            tUserInfo.setRoleInfos(roleInfos);
        }
            tUserInfo.setUtime(new Date());
        TUserInfo save = userepository.save(tUserInfo);


        if (SystemUtils.isNull(save)){
            logger.error("UserServiceimpl adduser TUserInfo null error" + save);
            return false;
        }
        logger.info("UserServiceimpl adduser end success");
            return true;
    }


    /**
     * 用户删除
     * @param ids 传过来的id是一个删一条，多个删多条
     * @return true 删除成功
     * 修改用户状态是否可用   0可用   1用户已删 2 锁定 3封号
     */
    @Override
    public boolean deluser(String ids) {
        String[] split = ids.split(",");
        if (SystemUtils.isNull(split) || split.length == 0){
            return false;
        }

        Long[] uids = new Long[split.length];
        for (int i = 0; i < split.length; i++) {
            long l = Long.parseLong(split[i]);
            uids[i] = l;
        }
        TUserInfo tUserInfo;
        //先查询再更新
        if (split.length == 1){//删除一条
            try {
                tUserInfo = userepository.findById(uids[0]).get();
            }catch (Exception e){
                return false;
            }
            if (SystemUtils.isNull(tUserInfo)){
                logger.error("UserServiceimpl deluser Fail SQL no this id");
                return false;
            }
            //修改用户状态
            tUserInfo.setUstatus(USTATUS_DEL);
            logger.info("UserServiceimpl deluser setUstatus ok");
            //更新用户
            TUserInfo save = userepository.save(tUserInfo);
            logger.info("UserServiceimpl deluser save TuserInfo");
            if (SystemUtils.isNull(save)){
                logger.error("UserServiceimpl deluser save TuserInfo Fail ");
                return false;
            }
                logger.info("UserServiceimpl deluser save TuserInfo ok end ");
                return true;
        }else {//删除多条

            for (Long uid : uids) {
                tUserInfo = userepository.findById(uid).get();
                if (SystemUtils.isNull(tUserInfo)){
                    logger.error("UserServiceimpl deluser Fail SQL no this id");
                    continue;
                }
                tUserInfo.setUstatus(USTATUS_DEL);
                logger.info("UserServiceimpl deluser setUstatus ok");
                TUserInfo save = userepository.save(tUserInfo);
                logger.info("UserServiceimpl deluser save TuserInfo ok end ");
            }
            return true;
        }
    }

    /**
     * 修改用户信息
     * @param userEntity
     * @return true 修改成功
     */
    @Override
    public boolean updUser(UserEntity userEntity) {
        TUserInfo tUserInfo;
        try {
            //在SQL查询到该id的用户信息
            tUserInfo = userepository.findById(userEntity.getUid()).get();
        }catch (Exception exception){
            return false;
        }
        logger.info("UserServiceimpl updUser tUserInfo is :  " +tUserInfo);
        if (!SystemUtils.isNull(userEntity.getUname())){
            logger.info("UserServiceimpl updUser tUserInfo Uname is :  " +tUserInfo.getUname());
            tUserInfo.setUname(userEntity.getUname());
        }
        if (!SystemUtils.isNull(userEntity.getUmail())){
            logger.info("UserServiceimpl updUser tUserInfo Umail is :  " +tUserInfo.getUmail());
            tUserInfo.setUmail(userEntity.getUmail());
        }
        if (!SystemUtils.isNull(userEntity.getUphone())){
            tUserInfo.setUphone(userEntity.getUphone());
        }
        if (!SystemUtils.isNull(userEntity.getUpass())){
            tUserInfo.setUpass(DigestUtils.md5DigestAsHex(userEntity.getUpass().getBytes()));
        }
        userepository.save(tUserInfo);
        return true;
    }

    /**
     * 查询
     * @return 所有用户的信息
     */
    @Override
    public ArrayList<UserEntity> findAllUSer() {
        List<TUserInfo> tUserInfos = userepository.findAll();
        ArrayList<UserEntity> arrayList = ConvertUtil.tUserInfoListConvertUserEntityList(tUserInfos);
        return arrayList;
    }

    /**
     * 条件查询
     * @return 符合条件的所有用户信息
     */
    @Override
    public ArrayList<UserEntity> findUserByWhere(UserEntity userEntity) {
        TUserInfo tUserInfo = ConvertUtil.userEntityConvertTUserInfo(userEntity);
        //匹配器(包括模糊查询，查询用户状态)
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("uphone",m->m.contains())
                .withMatcher("umail",m->m.contains())
                .withMatcher("ustatus",m->m.contains())
                .withMatcher("uid",m->m.contains());
                /*.withIgnorePaths("uid");*/
               /* .withIgnorePaths("ustatus");*/

        //根据实体类创建查询条件（根据电话uphone查询）
        Example example = Example.of(tUserInfo,matcher);
        List<TUserInfo> list = userepository.findAll(example);
        return ConvertUtil.tUserInfoListConvertUserEntityList(list) ;
    }

    /**
     * 按时间段查询
     * @return 符合时间的所有用户信息
     */
    @Override
    public ArrayList<UserEntity> findAllByUtimeBetween(String starttime, String endtime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date endtDate = new Date();
        try {
            startDate = sdf.parse(starttime);
            endtDate = sdf.parse(endtime);
            logger.info("UserServiceimpl findAllByUtimeBetween startDate is :"+ startDate);
            logger.info("UserServiceimpl findAllByUtimeBetween endtDate is :"+ endtDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<TUserInfo> tUserInfos = userepository.findAllByUtimeBetween(startDate, endtDate);
        return ConvertUtil.tUserInfoListConvertUserEntityList(tUserInfos);
    }

    /**
     * 分页查询
     * 包括：排序，条件
     * @return
     */
    @Override
    public Map<String, Object> pageQuery(UserEntity userEntity) {
        //默认的排序规则
        PageRequest of = PageRequest.of(userEntity.getCurrentPage(), userEntity.getPageSize());
        //如果有排序条件,按条件分页查询
        if (!SystemUtils.isNull(userEntity.getSort())){
            logger.info("UserServiceimpl pageQuery userEntity sort is :" + userEntity.getSort().toString());
            String[] sorts = userEntity.getSort().split(",");
            logger.info("UserServiceimpl pageQuery sorts is :" + sorts.length);
            if ("ASC".equals(userEntity.getSortType())){
                logger.info("UserServiceimpl pageQuery sortType is : ASC");
                logger.info("UserServiceimpl pageQuery sorts is : "+ sorts[0]);
               of = PageRequest.of(userEntity.getCurrentPage(), userEntity.getPageSize(), Sort.Direction.ASC,sorts);
            }else {
                logger.info("UserServiceimpl pageQuery sortType is : DESC");
               of = PageRequest.of(userEntity.getCurrentPage(), userEntity.getPageSize(), Sort.Direction.DESC,sorts);
            }
        }
        //条件查询
        Specification<TUserInfo> spec = new Specification<TUserInfo>() {
            @Override
            public Predicate toPredicate(Root<TUserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //生成条件的对象
                Predicate predicate = cb.conjunction();
                if (!SystemUtils.isNull(userEntity.getUmail())){
                    predicate.getExpressions().add(cb.equal(root.get("umail"),userEntity.getUmail()));
                }
                if (!SystemUtils.isNull(userEntity.getUphone())){
                    predicate.getExpressions().add(cb.like(root.get("uphone").as(String.class),"%"+userEntity.getUphone()+"%"));
                }
                if (!SystemUtils.isNull(userEntity.getStarttime())){
                    predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("utime").as(String.class),userEntity.getStarttime()));
                }
                if (!SystemUtils.isNull(userEntity.getEndtime())){
                    predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("utime").as(String.class),userEntity.getEndtime()));
                }
                return predicate;
            }
        };
        Page<TUserInfo> page = userepository.findAll(spec, of);
        //数据库查到的是TuserInfo，要转为前端需要的userEntity
        List<TUserInfo> userInfoList = page.getContent();
        logger.info("UserServiceimpl pageQuery userInfoList size is :" + userInfoList.size() );
        ArrayList<UserEntity> userEntityArrayList = ConvertUtil.tUserInfoListConvertUserEntityList(userInfoList);
        //将分页所需要的信息包装在map里，便于传入ResponseResult里的result
        Map<String, Object> map = new HashMap<>();
        map.put("users",userEntityArrayList);//查询到的列表信息
        map.put("totalPages",page.getTotalPages());//总页数
        map.put("currentPage",userEntity.getCurrentPage());//前端传过来的当前页数，默认第一页（userEntity类设置默认第一页）
        map.put("pageSize",userEntity.getPageSize());//前端传过来的页大小
        return map;
    }
}
