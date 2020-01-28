package com.xd.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: k
 * @Date: 2020/1/28 17:20
 * @Description:订单表
 */
@Entity
@Data
public class OrderMaster {
    // 订单id
    @Id
    private String orderId;
    // 买家名字
    private String buyerName;
    // 买家电话
    private String buyerPhone;
    // 买家地址
    private String buyerAddress;
    // 买家微信openid
    private String buyerOpenid;
    // 金额
    private BigDecimal orderAmount;
    // 订单状态,默认0：新下单
    private Integer orderStatus;
    // 支付状态，默认未支付：0
    private Integer payStatus;








}
