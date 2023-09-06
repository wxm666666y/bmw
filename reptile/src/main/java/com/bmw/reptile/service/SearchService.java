package com.bmw.reptile.service;

import com.bmw.reptile.model.Information;

import java.util.List;
import java.util.Map;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/6
 */
public interface SearchService {

    /**
     * 搜索
     * @param word
     * @return
     */
    List<Information> findLikeInfo(String word );

    /**
     * 定时任务
     */
    void importNews();

    /**
     * 搜索时将数据放入缓存
     * @param word
     * @return
     */
    Double record(String word);

    /**
     * 排行榜实现
     * @return
     */
    List<Map<String, Object>> searchRank();
}
