package com.example.order.controller;

import com.example.order.base.R;
import com.example.order.pojo.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/8
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/add")
    public R addOrder(@RequestBody Order order){
        return new R(orderService.insertOrder(order)==1, orderService.selectById(order.getId()));
    }

    @RequestMapping("/payment")
    public R pay(@RequestBody Order order){
        order.setState(2);
        return new R(orderService.updateOrder(order)==1, order);
    }
}
