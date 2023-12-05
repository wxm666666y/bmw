package com.example.order.controller;

import com.example.order.base.R;
import com.example.order.pojo.Order;
import com.example.order.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/13
 */
@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueueService queueService;

    @RequestMapping("/enqueue")
    public R enqueueOrder(@RequestBody Order order){
        order.setCreateTime(new Date());
        order.setFinishNewTime(15);
        queueService.enqueue(order);
        return new R(true, order);
    }

    @RequestMapping("/add")
    public R addOrder(){
        queueService.dequeueAndProcess();
        return new R(true, "add" );
    }
}
