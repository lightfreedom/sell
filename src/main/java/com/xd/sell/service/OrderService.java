package com.xd.sell.service;

import com.xd.sell.dataobject.OrderMaster;
import com.xd.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Auther: k
 * @Date: 2020/1/29 09:40
 * @Description:
 */
public interface OrderService {
    // 创建订单
    OrderDTO create(OrderDTO orderDTO);

    // 查询单个订单
    OrderDTO findOne(String id);

    // 查询订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    // 取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    // 完结订单
    OrderDTO finish(OrderDTO orderDTO);

    // 支付订单
    OrderDTO paid(OrderDTO orderDTO);
}
