package cn.dm.service;


import cn.dm.common.Dto;
import cn.dm.vo.ItemDetailVo;
import cn.dm.vo.ItemPriceVo;
import cn.dm.vo.ItemSchedulerVo;

import java.util.List;

public interface ItemDetailService {
    public Dto<ItemDetailVo> queryItemDetail(Long id)throws  Exception;

    /**
     * 根据商品ID查询排期
     * @param itemId
     * @return
     * @throws Exception
     */
    public Dto<List<ItemSchedulerVo>> queryItemScheduler(Long itemId)throws Exception;


    /**
     * 根据排期ID查询价格
     * @param id
     * @return
     * @throws Exception
     */
    public Dto<List<ItemPriceVo>> queryItemPrice(Long id)throws Exception;
 }
