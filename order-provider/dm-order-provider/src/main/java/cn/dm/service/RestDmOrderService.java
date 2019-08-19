package cn.dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dm.mapper.DmOrderMapper;
import cn.dm.pojo.DmOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dm
 */
@RestController
public class RestDmOrderService {

    @Autowired
    private DmOrderMapper dmOrderMapper;

    @RequestMapping(value = "/getDmOrderById", method = RequestMethod.POST)
    public DmOrder getDmOrderById(@RequestParam("id") Long id) throws Exception {
        return dmOrderMapper.getDmOrderById(id);
    }

    @RequestMapping(value = "/getDmOrderListByMap", method = RequestMethod.POST)
    public List<DmOrder> getDmOrderListByMap(@RequestParam Map<String, Object> param) throws Exception {
        return dmOrderMapper.getDmOrderListByMap(param);
    }

    @RequestMapping(value = "/getDmOrderCountByMap", method = RequestMethod.POST)
    public Integer getDmOrderCountByMap(@RequestParam Map<String, Object> param) throws Exception {
        return dmOrderMapper.getDmOrderCountByMap(param);
    }

    @RequestMapping(value = "/qdtxAddDmOrder", method = RequestMethod.POST)
    public Long qdtxAddDmOrder(@RequestBody DmOrder dmOrder) throws Exception {
        dmOrder.setCreatedTime(new Date());
        dmOrderMapper.insertDmOrder(dmOrder);
        return dmOrder.getId();
    }

    @RequestMapping(value = "/qdtxModifyDmOrder", method = RequestMethod.POST)
    public Long qdtxModifyDmOrder(@RequestBody DmOrder dmOrder) throws Exception {
        dmOrder.setUpdatedTime(new Date());
        dmOrderMapper.updateDmOrder(dmOrder);
        return dmOrder.getId();
    }

    @RequestMapping(value = "/deleteDmOrderById",method = RequestMethod.POST)
    public Integer deleteDmOrderById(@RequestParam("id") Long id)throws Exception{
        return dmOrderMapper.deleteDmOrderById(id);
    }
}
