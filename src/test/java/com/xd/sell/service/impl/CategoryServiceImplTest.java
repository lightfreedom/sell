package com.xd.sell.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.xd.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    // 实现的测试，不要用接口
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(10);
        System.out.println(productCategory.toString());
//        Assert.assertNotNull(productCategory);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        System.out.println(list);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list);
    }

    @Test
    public void save() {
        ProductCategory productCategory =new ProductCategory("新",666);
        ProductCategory save = categoryService.save(productCategory);
        System.out.println(save);
    }
}