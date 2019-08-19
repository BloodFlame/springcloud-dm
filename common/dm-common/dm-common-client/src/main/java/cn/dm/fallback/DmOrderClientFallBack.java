package cn.dm.fallback;

import cn.dm.pojo.DmOrder;

import cn.dm.client.RestDmOrderClient;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
@Component
public class DmOrderClientFallBack implements RestDmOrderClient {


    @Override
    public DmOrder getDmOrderById(Long id)throws Exception{
        return null;
    }

    @Override
    public List<DmOrder>	getDmOrderListByMap(Map<String,Object> param)throws Exception{
        return null;
    }

    @Override
    public Integer getDmOrderCountByMap(Map<String,Object> param)throws Exception{
        return null;
    }

    @Override
    public Long qdtxAddDmOrder(DmOrder dmOrder)throws Exception{
        return null;
    }

    @Override
    public Long qdtxModifyDmOrder(DmOrder dmOrder)throws Exception{
        return null;
    }

    @Override
    public Long deleteDmOrderById(Long id) throws Exception {
        return null;
    }
}
