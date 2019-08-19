package cn.dm.controller;

import cn.dm.common.Dto;
import cn.dm.common.DtoUtil;
import cn.dm.service.DmLinkUserService;
import cn.dm.service.DmLoginService;
import cn.dm.vo.DmUserVO;
import cn.dm.vo.QueryLinkUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LinkUserController {

    @Autowired
    private DmLoginService dmLoginService;
    @Autowired
    private DmLinkUserService dmLinkUserService;

    @RequestMapping(value = "/v/queryLinkUser", method = RequestMethod.POST)
    public Dto queryLinkUserByUserId(HttpServletRequest request) throws Exception {
        String tokenString = request.getHeader("token");
        //根据用户TOKEN获取当前联系人的信息
        DmUserVO dmUserVO = dmLoginService.loadCurrentUserByTokenAsDmUserVo(tokenString);
        //根据当前登陆的用户ID获取常用联系人
        List<QueryLinkUserVo> queryLinkUserVos = dmLinkUserService.findLinkUserByUserId(dmUserVO.getUserId());
        return DtoUtil.returnDataSuccess(queryLinkUserVos);
    }
}
