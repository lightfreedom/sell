package com.xd.sell.repository;

import com.xd.sell.dataobject.ProductInfo;
import com.xd.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void saveTest(){
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("醪糟汤");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好吃");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfosList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfosList.size());

    }
}