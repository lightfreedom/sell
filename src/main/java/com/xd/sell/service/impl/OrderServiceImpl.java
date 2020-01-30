package com.xd.sell.service.impl;

import com.xd.sell.Exception.SellException;
import com.xd.sell.dataobject.OrderDetail;
import com.xd.sell.dataobject.OrderMaster;
import com.xd.sell.dataobject.ProductInfo;
import com.xd.sell.dto.CartDTO;
import com.xd.sell.dto.OrderDTO;
import com.xd.sell.enums.OrderStatusEnum;
import com.xd.sell.enums.PayStatusEnum;
import com.xd.sell.enums.ResultEnum;
import com.xd.sell.repository.OrderDetailRepository;
import com.xd.sell.repository.OrderMasterRepository;
import com.xd.sell.service.OrderService;
import com.xd.sell.service.ProductService;
import com.xd.sell.utils.KeyUtil;
import org.hibernate.hql.internal.classic.PreprocessingParser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: k
 * @Date: 2020/1/29 09:56
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional  //事务
    public OrderDTO create(OrderDTO orderDTO) {

        // 生成orderId
        String orderId = KeyUtil.genUniqueKey();
        // 定义订单总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1.查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 2.计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            // 订单详情入库
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            // 拷贝查出来的属性
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        // 3.写入订单数据库（orderMaster和orderDetail）
        OrderMaster orderMaster = new OrderMaster();

        // 属性的值是null，也会被拷贝过去，所以如果要补充其他属性值，要放在这个方法后面
        BeanUtils.copyProperties(orderDTO, orderMaster);

        // 补充属性
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());

        orderMasterRepository.save(orderMaster);

        // 4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String id) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
