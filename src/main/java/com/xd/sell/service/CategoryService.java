package com.xd.sell.service;

import com.xd.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: k
 * @Date: 2020/1/26 20:00
 * @Description:类目
 */
public interface CategoryService {
   ProductCategory findOne(Integer categoryId);

   List<ProductCategory> findAll();

   List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

   ProductCategory save(ProductCategory productCategory);
}
