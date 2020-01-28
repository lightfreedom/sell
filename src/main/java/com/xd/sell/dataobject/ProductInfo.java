package com.xd.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Auther: k
 * @Date: 2020/1/27 17:04
 * @Description:
 */
@Entity
@Data
@DynamicUpdate   // 时间动态更新
public class ProductInfo {
    @Id
    private String productId;
    // 产品名称
    private String productName;
    // 单价
    private BigDecimal productPrice;
    // 库存
    private Integer productStock;
    // 描述
    private String productDescription;
    //小图连接
    private String productIcon;
    // 商品状态 0正常；1下架
    private Integer productStatus;
    // 类目编号
    private Integer categoryType;

}
