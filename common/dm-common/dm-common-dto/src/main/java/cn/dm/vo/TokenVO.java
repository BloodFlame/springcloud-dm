package cn.dm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/28.
 */
public class TokenVO implements Serializable {
    /**
     * 用户认证凭据
     */
    private String token;
    /**
     * 有效时长
     */
    private long expTime;
    /**
     * 生成时间
     */
    private long genTime;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public long getExpTime() {
        return expTime;
    }
    public void setExpTime(long expTime) {
        this.expTime = expTime;
    }
    public long getGenTime() {
        return genTime;
    }
    public void setGenTime(long genTime) {
        this.genTime = genTime;
    }

    public TokenVO() {
        super();
    }
    public TokenVO(String token, long expTime, long genTime) {
        super();
        this.token = token;
        this.expTime = expTime;
        this.genTime = genTime;
    }
}
