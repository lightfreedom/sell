package com.xd.sell.repository;

import com.xd.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: k
 * @Date: 2020/1/28 20:43
 * @Description:订单详情dao层
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String ordId);
}
