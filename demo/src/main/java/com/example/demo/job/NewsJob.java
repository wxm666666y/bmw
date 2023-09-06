package com.example.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/6
 */
@Component
public class NewsJob {
    private static final Logger LOG = LoggerFactory.getLogger(NewsJob.class);

    @Scheduled(cron = "0/1 * * * * ?")
    public void ru() {
        LOG.info("===开始爬取内容定时任务===");
        LOG.info("===结束爬取内容定时任务===");
    }
}