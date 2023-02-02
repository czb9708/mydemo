package com.msb.ldx.wms.wms.code;

/**
 * @author: zebin
 * @Date: 2022/12/16 - 12 - 16 - 23:41
 * @Description: com.msb.baoguan.code
 * @version: 1.0
 */
public class UntiCode {

    private int UNTI_QUERY_SUCCESS = 10000;
    private String UNTI_QUERY_SUCCESS_MSG = "操作成功";

    private int UNTI_QUERY_FAIL = 10001;
    private String UNTI_QUERY_FAIL_MSG = "操作失败";

    public int getUNTI_QUERY_SUCCESS() {
        return UNTI_QUERY_SUCCESS;
    }

    public void setUNTI_QUERY_SUCCESS(int UNTI_QUERY_SUCCESS) {
        this.UNTI_QUERY_SUCCESS = UNTI_QUERY_SUCCESS;
    }

    public String getUNTI_QUERY_SUCCESS_MSG() {
        return UNTI_QUERY_SUCCESS_MSG;
    }

    public void setUNTI_QUERY_SUCCESS_MSG(String UNTI_QUERY_SUCCESS_MSG) {
        this.UNTI_QUERY_SUCCESS_MSG = UNTI_QUERY_SUCCESS_MSG;
    }

    public int getUNTI_QUERY_FAIL() {
        return UNTI_QUERY_FAIL;
    }

    public void setUNTI_QUERY_FAIL(int UNTI_QUERY_FAIL) {
        this.UNTI_QUERY_FAIL = UNTI_QUERY_FAIL;
    }

    public String getUNTI_QUERY_FAIL_MSG() {
        return UNTI_QUERY_FAIL_MSG;
    }

    public void setUNTI_QUERY_FAIL_MSG(String UNTI_QUERY_FAIL_MSG) {
        this.UNTI_QUERY_FAIL_MSG = UNTI_QUERY_FAIL_MSG;
    }

    @Override
    public String toString() {
        return "UntiCode{" +
                "UNTI_QUERY_SUCCESS=" + UNTI_QUERY_SUCCESS +
                ", UNTI_QUERY_SUCCESS_MSG='" + UNTI_QUERY_SUCCESS_MSG + '\'' +
                ", UNTI_QUERY_FAIL=" + UNTI_QUERY_FAIL +
                ", UNTI_QUERY_FAIL_MSG='" + UNTI_QUERY_FAIL_MSG + '\'' +
                '}';
    }
}
