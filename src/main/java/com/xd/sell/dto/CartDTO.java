package com.xd.sell.dto;

import lombok.Data;

/**
 * @Auther: k
 * @Date: 2020/1/29 11:32
 * @Description: 购物车
 */
@Data
public class CartDTO {
    // 商品id
    private String productId;
    // 数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
