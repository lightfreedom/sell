package com.xd.sell.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10, "商品不存在！"),
    PRODUCT_STOCK_ERROR(11, "商品库存不足！"),
    ORDER_NOT_EXIST(12, "订单不存在！"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在！"),
    ORDER_STATUS_ERROR(14, "订单状态错误！"),
    ORDER_CANCEL_ERROR(15, "订单取消失败！"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空！"),
    PAY_STATUS_ERROR(17, "支付状态不正确！"),
    ORDER_UPDATE_FAIL(17, "订单更新失败！");


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
