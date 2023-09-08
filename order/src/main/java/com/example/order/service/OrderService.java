package com.example.order.service;

import com.example.order.pojo.Order;
import org.apache.ibatis.annotations.Param;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/8
 */
public interface OrderService {
    Order selectById(@Param("id") Long id );

    int insertOrder( Order order );

    int updateOrder( Order order );

    int deleteById( @Param("id") Long id );

    void startTicketTimeoutTask();
}
