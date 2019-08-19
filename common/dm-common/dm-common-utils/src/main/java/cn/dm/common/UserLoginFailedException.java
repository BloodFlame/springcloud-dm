package cn.dm.common;
/**
 * 用户登录失败异常
 * @author hduser
 *
 */
public class UserLoginFailedException extends Exception {

	public UserLoginFailedException(String msg){
		super(msg);
	}
}
