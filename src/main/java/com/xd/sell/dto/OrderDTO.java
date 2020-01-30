package com.xd.sell.dto;

import com.xd.sell.dataobject.OrderDetail;
import com.xd.sell.enums.OrderStatusEnum;
import com.xd.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: k
 * @Date: 2020/1/29 09:49
 * @Description:
 */
@Data
public class OrderDTO {
    // 订单id
    private String orderId;
    // 买家名字
    private String buyerName;
    // 买家电话
    private String buyerPhone;
    // 买家地址
    private String buyerAddress;
    // 买家微信openid
    private String buyerOpenid;
    // 金额。
    private BigDecimal orderAmount ;
    // 订单状态,默认0：新下单
    private Integer orderStatus;
    // 支付状态，默认未支付：0
    private Integer payStatus;
    // 订单detail
    private List<OrderDetail> orderDetailList;
}
