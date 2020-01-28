package com.xd.sell.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.xd.sell.dataobject.ProductInfo;
import com.xd.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() {
        ProductInfo one = productService.findOne("123456");
        Assert.assertEquals("123456", one.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        System.out.println(upAll);

    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 10);
        Page<ProductInfo> all = productService.findAll(request);
        Assert.assertNotEquals(0,all.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("654322");
        productInfo.setProductName("柠檬芦荟");
        productInfo.setProductPrice(new BigDecimal(8));
        productInfo.setProductStock(15);
        productInfo.setProductDescription("");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}