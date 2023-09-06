package com.bmw.reptile.job;

import com.bmw.reptile.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/6
 */
@Component
public class NewsJob {
    private static final Logger LOG = LoggerFactory.getLogger(NewsJob.class);
    @Autowired
    SearchService searchService;

    @Scheduled(cron = "0 0/20 * * * ?")
    public void run() {
        LOG.info("===开始爬取内容定时任务===");
        searchService.importNews();
        LOG.info("===结束爬取内容定时任务===");
    }
}