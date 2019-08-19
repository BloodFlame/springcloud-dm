package cn.dm.controller;

import cn.dm.common.Dto;
import cn.dm.service.OrderService;
import cn.dm.vo.CreateOrderVo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/createOrder")
    public Dto createOrder(@RequestBody CreateOrderVo orderVo) throws Exception {
        return orderService.createOrder(orderVo);
    }
}
