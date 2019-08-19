package cn.dm.client;

import cn.dm.pojo.DmOrder;

import cn.dm.fallback.DmOrderClientFallBack;

import java.util.List;
import java.util.Map;

import cn.dm.config.DmConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by dm
 */
@FeignClient(name = "dm-order-provider", configuration = DmConfiguration.class, fallback = DmOrderClientFallBack.class)
public interface RestDmOrderClient {
    @RequestMapping(value = "/getDmOrderById", method = RequestMethod.POST)
    public DmOrder getDmOrderById(@RequestParam("id") Long id) throws Exception;

    @RequestMapping(value = "/getDmOrderListByMap", method = RequestMethod.POST)
    public List<DmOrder> getDmOrderListByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/getDmOrderCountByMap", method = RequestMethod.POST)
    public Integer getDmOrderCountByMap(@RequestParam Map<String, Object> param) throws Exception;

    @RequestMapping(value = "/qdtxAddDmOrder", method = RequestMethod.POST)
    public Long qdtxAddDmOrder(@RequestBody DmOrder dmOrder) throws Exception;

    @RequestMapping(value = "/qdtxModifyDmOrder", method = RequestMethod.POST)
    public Long qdtxModifyDmOrder(@RequestBody DmOrder dmOrder) throws Exception;

    @RequestMapping(value = "/deleteDmOrderById", method = RequestMethod.POST)
    public Long deleteDmOrderById(@RequestParam("id") Long id) throws Exception;


}

