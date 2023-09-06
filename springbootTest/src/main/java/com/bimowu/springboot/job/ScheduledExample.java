package com.bimowu.springboot.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/5
 */
@Component
public class ScheduledExample {
    // @Scheduled(fixedRate = 5000)
    // 上一次开始执行时间点之后5秒再执行
    public void job1() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }
    // @Scheduled(fixedDelay = 5000)
    // 上一次执行完毕时间点之后5秒再执行
    public void job2() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }
    // @Scheduled(initialDelay = 1000, fixedRate = 5000)
    // 第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    public void job3() {
        System.out.println( Thread.currentThread() + " now is " +  LocalTime.now());
    }
    @Scheduled(cron = "0/1 * * * * ?")
    // cron表达式
    public void job4() {
        System.out.println( Thread.currentThread() + " now is " + LocalTime.now());
    }
}
