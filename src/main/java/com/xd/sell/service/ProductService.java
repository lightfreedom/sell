package com.xd.sell.service;

import com.xd.sell.dataobject.ProductInfo;
import com.xd.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: k
 * @Date: 2020/1/27 18:16
 * @Description:
 */

public interface ProductService {
    ProductInfo findOne(String ProductId);
    // 查询所有在架商品列表
    List<ProductInfo> findUpAll();

    // 查询所有
    Page<ProductInfo> findAll(Pageable pageable);

    //保存更新
    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
