package com.xd.sell.repository;

import com.xd.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: k
 * @Date: 2020/1/28 20:34
 * @Description:订单表dao层
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    // 根据买家openid，分页查询
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
