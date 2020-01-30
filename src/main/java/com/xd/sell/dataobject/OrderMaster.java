package com.xd.sell.dataobject;

import com.xd.sell.enums.OrderStatusEnum;
import com.xd.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: k
 * @Date: 2020/1/28 17:20
 * @Description:订单表
 */
@Entity
@Data
@DynamicUpdate
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
    // 金额。
    private BigDecimal orderAmount ;
    // 订单状态,默认0：新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    // 支付状态，默认未支付：0
    private Integer payStatus= PayStatusEnum.NEW.getCode();

//    @Transient  // 在数据库对应时忽略此字段，但是不建议这么做。
//    private List<OrderDetail> orderDetailList;








}
