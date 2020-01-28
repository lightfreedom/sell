package com.xd.sell.repository;

import com.xd.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: k
 * @Date: 2020/1/27 17:21
 * @Description:
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    // 根据状态查询商品上下架状态
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
