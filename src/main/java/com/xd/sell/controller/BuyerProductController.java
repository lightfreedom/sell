package com.xd.sell.controller;

import com.xd.sell.VO.ProductInfoVO;
import com.xd.sell.VO.ProductVO;
import com.xd.sell.VO.ResultVO;
import com.xd.sell.dataobject.ProductCategory;
import com.xd.sell.dataobject.ProductInfo;
import com.xd.sell.service.CategoryService;
import com.xd.sell.service.ProductService;
import com.xd.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: k
 * @Date: 2020/1/27 20:45
 * @Description:
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 2.查询类目（一次性查询）
        //   List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法
//        for(ProductInfo productInfo :productInfoList ){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简方法（lambda） 商家商品所包含的类型
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());


        // 根据商家商品的类型list查询Category表
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3.数据拼装
        // 第二层类型的list
        List<ProductVO> productVOList = new ArrayList<>();
        // 根据类型遍历每种类型的商品
        for (ProductCategory productCategory : productCategoryList) {
            // 获取类型属性
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            // 第三层某个类型的商品list
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            // 遍历所有商品，找到属于某种类型的商品
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // Spring提供的把一个类的属性值拷贝到另一个对象中
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }


        return ResultVOUtil.success(productVOList);
    }
}
