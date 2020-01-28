package com.xd.sell.repository;

import com.xd.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.SoundbankResource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: k
 * @Date: 2020/1/26
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

//    // 寻找
//    @Test
//    public void findOneTest() {
//        ProductCategory productCategory = repository.findOne(1);
//        System.out.println(productCategory.toString());
//    }

    // 新增
    @Test
    public void saveTest() {
//        ProductCategory category = new ProductCategory();
//        category.setCategoryName("她最爱的");
//        category.setCategoryType(77);
        ProductCategory productCategory = new ProductCategory("您最爱的", 55);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);

    }

    // 更新
    @Test
    public void updateTest() {
        ProductCategory one = repository.findOne(8);
        System.out.println(one.toString());
        one.setCategoryName("女儿的最爱");
        one.setCategoryType(111);
        repository.save(one);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}