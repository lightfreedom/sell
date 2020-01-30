package com.xd.sell.repository;

import com.xd.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail detail = new OrderDetail();
        detail.setDetailId("123");
        detail.setOrderId("1");
        detail.setProductId("123456");
        detail.setProductName("牛肉");
        detail.setProductIcon("www.baidu.com");
        detail.setProductPrice(new BigDecimal(1122));
        detail.setProductQuantity(2300);
        OrderDetail save = repository.save(detail);
        Assert.assertNotNull(save);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("1");
        System.out.println(result.toString());
    }
}