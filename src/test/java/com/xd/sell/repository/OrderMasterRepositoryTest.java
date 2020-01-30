package com.xd.sell.repository;

import com.xd.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    // 微信openid
    private final String OPENID="fish";

    // 保存
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("3");
        orderMaster.setBuyerAddress("莫邪路");
        orderMaster.setBuyerName("张波涛");
        orderMaster.setBuyerOpenid("fish");
        orderMaster.setBuyerPhone("12342343");
        orderMaster.setOrderAmount(new BigDecimal(822.4));

        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);


    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0, 10);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        System.out.println(result.getContent());
    }
}