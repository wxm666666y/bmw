package com.example.order.service.Impl;

import com.example.order.dao.OrderDao;
import com.example.order.pojo.Order;
import com.example.order.service.OrderService;
import com.example.order.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/8
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
    public static final String ORDERID = "orderId:";

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    OrderDao orderDao;

    @Override
    public Order selectById(Long id) {
        return orderDao.selectById(id);
    }

    @Override
    public int insertOrder(Order order) {
        order.setCreateTime(new Date());
        order.setFinishNewTime(15);
        return orderDao.insertOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public int deleteById(Long id) {
        return orderDao.deleteById(id);
    }

//    @Scheduled(fixedRate = 6000) // 每6秒执行一次
    @Override
    public void startTicketTimeoutTask() {
        LOG.info("===检测超时订单===");
        List<Order> unpaidOrders = orderDao.getUnpaidOrders();
        Date currentTime = new Date();
        Iterator<Order> iterator = unpaidOrders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
//            Date createTime = order.getCreateTime();
            Date finishTime = order.getFinishTime();
//            long minutesSinceCreation = (new Date().getTime() - finishTime.getTime()) / (1000 * 60);
            if (new Date().getTime() >= finishTime.getTime()) {
                // 超过15分钟，退票并从未付款订单列表中移除
                LOG.info("===逻辑删除超时订单==="+"id:"+order.getId()+"name:"+order.getName());
                iterator.remove();
                order.setState(0);
                orderDao.updateOrder(order);
                // 可以在此处添加其他退款逻辑
            }
        }
    }

    @Override
    public boolean insertOrderRedis(Order order) {
        Long id = order.getId();
        String orderId = ORDERID + id;
        return redisUtil.set(orderId, order);
    }

    @Override
    public boolean updateOrderRedis(Order order) {
        Long id = order.getId();
        String orderId = ORDERID + id;
        return redisUtil.set(orderId, order);
    }

    @Override
    public void deleteByIdRedis(Long id) {
        String orderId = ORDERID + id;
        redisUtil.del(orderId);
    }


}
