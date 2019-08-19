package cn.dm.common;

import java.util.Map;

/**
 * <p>通用异常的处理</p>
 *
 * @author zzshang
 * @version v1.0
 * @since 2015/5/19
 */
public class BaseException extends Exception {
    private static final long serialVersionUID = 1L;
    private IErrorCode iErrorCode;
    private String errorCode;
    private String errorMessage;
    private Map<String, Object> errorData;

    public BaseException(IErrorCode iErrorCode) {
        super(iErrorCode.getErrorMessage());
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public IErrorCode getiErrorCode() {
        return iErrorCode;
    }

    public void setiErrorCode(IErrorCode iErrorCode) {
        this.iErrorCode = iErrorCode;
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

    public Map<String, Object> getErrorData() {
        return errorData;
    }

    public void setErrorData(Map<String, Object> errorData) {
        this.errorData = errorData;
    }
}
