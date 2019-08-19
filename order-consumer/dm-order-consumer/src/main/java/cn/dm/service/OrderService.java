package cn.dm.service;

import cn.dm.common.Dto;
import cn.dm.vo.CreateOrderVo;

public interface OrderService {
    /**
     * 下单接口
     *
     * @param orderVo
     * @return
     * @throws Exception
     */
    public Dto createOrder(CreateOrderVo orderVo) throws Exception;
}
