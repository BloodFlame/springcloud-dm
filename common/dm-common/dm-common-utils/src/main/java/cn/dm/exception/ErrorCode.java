package cn.dm.exception;

import cn.dm.common.IErrorCode;

public enum ErrorCode implements IErrorCode {
    /**通用异常**/
    COMMON_NO_LOGIN("0001","用户未登录"),
    COMMON_Exception("0002","系统异常"),
    /**节目项目异常**/

    ;
    private String errorCode;
    private String errorMessage;

    private ErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
