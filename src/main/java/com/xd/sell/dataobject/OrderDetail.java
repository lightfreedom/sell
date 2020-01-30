package com.xd.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: k
 * @Date: 2020/1/28 19:34
 * @Description:订单详情表
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {
    // id
    @Id
    private String detailId;
    // 订单id
    private String orderId;
    // 商品id
    private String productId;
    // 商品名称
    private String productName;
    // 商品单价
    private BigDecimal productPrice;
    // 商品数量
    private Integer productQuantity;
    // 商品图片
    private String productIcon;
}
