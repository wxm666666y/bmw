package com.example.order;

import com.example.order.dao.OrderDao;
import com.example.order.pojo.Order;
import com.example.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class OrderApplicationTests {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDao dao;

    @Test
    void contextLoads() {
//        Order order = new Order();
//        order.setName("123");
//        orderService.insertOrder(order);
//        Order order = dao.selectById(5L);
//        Date finishTime = order.getFinishTime();
//        System.out.println(new Date().getTime() >= finishTime.getTime());

        Order order = orderService.selectById(7L);
        order.setState(2);
        orderService.updateOrder(order);
    }

    @Test
    void contextLoadsRedis() {
        Order order = orderService.selectById(7L);
//        order.setState(1);
//        System.out.println(orderService.insertOrderRedis(order));
//        System.out.println(orderService.updateOrderRedis(order));
        orderService.deleteByIdRedis(order.getId());
    }

}
