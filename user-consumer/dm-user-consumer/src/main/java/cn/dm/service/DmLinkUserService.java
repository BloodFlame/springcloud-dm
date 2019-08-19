package cn.dm.service;

import cn.dm.vo.QueryLinkUserVo;

import java.util.List;

public interface DmLinkUserService {

    /**
     * 根据当前登陆的用户ID获取常用联系人
     * @param userId
     * @return
     * @throws Exception
     */
    public List<QueryLinkUserVo> findLinkUserByUserId(Long userId)throws Exception;
}
