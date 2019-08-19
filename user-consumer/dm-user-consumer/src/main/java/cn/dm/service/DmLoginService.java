package cn.dm.service;

import cn.dm.pojo.DmUser;
import cn.dm.vo.DmUserVO;

public interface DmLoginService {
    /**
     * 账号密码登陆
     *
     * @param dmUser
     * @return
     * @throws Exception
     */
    public Object[] login(DmUser dmUser) throws Exception;

    /**
     * 根据token获取当前登陆的用户信息
     *
     * @param tokenString
     * @return
     * @throws Exception
     */
    public DmUserVO loadCurrentUserByTokenAsDmUserVo(String tokenString) throws Exception;
}
