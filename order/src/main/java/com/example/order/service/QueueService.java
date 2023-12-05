package com.example.order.service;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/13
 */
public interface QueueService {

    /**
     * 向队列中添加消息
     */
    public void enqueue(Object message);

    /**
     * 从队列中获取消息并处理
     */
    public void dequeueAndProcess();
}
