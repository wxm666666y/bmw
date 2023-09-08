package com.example.order.dao;

import com.example.order.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/8
 */
@Repository
public interface OrderDao {

    Order selectById(@Param("id") Long id );

    int insertOrder( Order order );

    int updateOrder( Order order );

    int deleteById( @Param("id") Long id );

    List<Order> getUnpaidOrders();
}
