package com.example.order.service.Impl;

import com.example.order.dao.OrderDao;
import com.example.order.pojo.Order;
import com.example.order.service.QueueService;
import com.example.order.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/13
 */
@Service
public class QueueServiceImpl implements QueueService {

    // 定义队列的名称
    private static final String QUEUE_NAME = "my_queue";

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    OrderDao orderDao;

    @Autowired
    ObjectMapper objectMapper; // Jackson ObjectMapper，用于序列化和反序列化

    @Override
    public void enqueue(Object order) {
        try {
            // 将Order对象序列化为JSON字符串
            String orderJson = objectMapper.writeValueAsString(order);
            // 存储JSON字符串到队列
            redisUtil.lSet(QUEUE_NAME, orderJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dequeueAndProcess() {
        while (true) {
            // 从队列的左侧弹出消息（FIFO）
            List<Object> list = redisUtil.lGet(QUEUE_NAME, 0, 0);
            Object message = list.get(0);
            if (message != null && message instanceof String) {
                try {
                    // 将JSON字符串反序列化为Order对象
                    String orderJson = (String) message;
                    Order order = objectMapper.readValue(orderJson, Order.class);

                    // 处理消息的逻辑，可以是异步任务等
                    processMessage(order);

                    // 处理完成后，将消息从队列中移除
                    redisUtil.lRemove(QUEUE_NAME, 1, message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // 如果队列为空，休眠一段时间再尝试获取消息
                try {
                    Thread.sleep(2000); // 休眠2秒钟
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /**
     * 处理消息的逻辑
     */
    private void processMessage(Object message) {
        // 在这里添加处理消息的具体逻辑，可以是发送邮件、生成报告等异步任务
        orderDao.insertOrder((Order) message);
        System.out.println("处理消息: " + message);
    }
}
