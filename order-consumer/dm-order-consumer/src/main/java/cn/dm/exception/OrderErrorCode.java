package cn.dm.exception;

import cn.dm.common.IErrorCode;

public enum OrderErrorCode implements IErrorCode {

    /**
     * 通用异常
     **/
    COMMON_NO_LOGIN("0001", "用户未登录"),
    COMMON_Exception("0002", "系统异常"),
    /**
     * 订单项目异常
     **/
    ORDER_SEAT_LOCKED("3001", "座位已被选购"),
    ORDER_NO_DATA("3002", "没有查询到数据"),;
    private String errorCode;
    private String errorMessage;

    private OrderErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
