package cn.dm.vo;

import java.io.Serializable;

/***
*   用户表
*/
public class DmUserRegisterVO implements Serializable {
    //手机号
    private String phone;
    //密码
    private String password;
    // 验证码
    private String vcode;
    //get set 方法
    public  void setPhone(String phone){ this.phone = phone; }
    public  String getPhone(){
        return this.phone;
    }
    public void setPassword (String  password){
        this.password=password;
    }
    public  String getPassword(){
        return this.password;
    }
    public String getVcode() { return vcode; }
    public void setVcode(String vcode) { this.vcode = vcode; }
}
