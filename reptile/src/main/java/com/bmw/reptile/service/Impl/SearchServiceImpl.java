package com.bmw.reptile.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bmw.reptile.dao.InformationDao;
import com.bmw.reptile.model.Information;
import com.bmw.reptile.service.SearchService;
import com.bmw.reptile.utils.http.HttpClientUtil;
import com.bmw.reptile.utils.http.HttpResult;
import com.bmw.reptile.utils.redis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/6
 */
@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger LOG = LoggerFactory.getLogger(SearchServiceImpl.class);
    private static final String URL = "https://news.baidu.com/widget?id=LocalNews&ajax=json";

    @Autowired
    private InformationDao informationDao;

    @Autowired
    HttpClientUtil httpClient;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 搜索
     * @param word
     * @return
     */
    @Override
    public List<Information> findLikeInfo(String word) {
        if(StringUtils.isNotEmpty(word)){
            record(word);
        }
        List<Information> likeInfo = informationDao.findLikeInfo(word);
        return likeInfo;
    }

    /**
     * 定时任务
     */
    @Override
    public void importNews() {
        LOG.info("===[开始调用爬取内容方法]===");
        try {
            HttpResult result = httpClient.doPost(URL);
            if (200 == result.getCode()) {
                JSONObject vo = JSON.parseObject(result.getBody());
                JSONArray arr = vo.getJSONObject("data").getJSONObject("LocalNews")
                        .getJSONObject("data").getJSONObject("rows").getJSONArray("first");
                Date date = new Date();
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject o = arr.getJSONObject(i);
                    if( informationDao.selectBySingleTag(DigestUtils.md5DigestAsHex(o.getString("title").getBytes())) != 0 ){
                        continue;
                    }
                    Information info = new Information();
                    info.setInfoSrc("bd");
                    info.setInfoImage(o.getString("imgUrl"));
                    info.setInfoText(o.getString("title"));
                    info.setInfoUrl(o.getString("url"));
                    info.setTime(o.getString("time"));
                    info.setSingleTag(DigestUtils.md5DigestAsHex(o.getString("title").getBytes()));
                    info.setCreateTime(date);
                    info.setUpdateTime(date);
                    informationDao.insert(info);
                    LOG.info("===========插入的ID:{}===========",info.getId());
//                    informationDao.insertIfNotExist(info);
                }
            }
        } catch (Exception e) {
            LOG.error("爬取内容方法异常：excp={}", e);
        }
        LOG.info("===[结束调用爬取内容方法]===");
    }

    /**
     * 搜索时将数据放入缓存
     * @param word
     * @return
     */
    @Override
    public Double record(String word) {
        try {
            return redisUtil.zincrby("NEWS_SEARCH:", word, 1);
        } catch (Exception e) {
            LOG.error("===[记录热搜词时出现异常：excp={}]===", e);
        }
        return 0D;
    }

    /**
     * 排行榜实现
     * @return
     */
    @Override
    public List<Map<String, Object>> searchRank() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            Set<ZSetOperations.TypedTuple<Object>> set = redisUtil.zrevrangeByScoreWithScores("NEWS_SEARCH:", 0D,
                    10000D);
            int i = 1;
            for (ZSetOperations.TypedTuple t : set) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("word", String.valueOf(t.getValue()));
                map.put("num", t.getScore().intValue());
                map.put("rank", i);
                list.add(map);
                i++;
            }
        } catch (Exception e) {
            LOG.error("===[记录热搜词时出现异常：excp={}]===", e);
        }
        return list;
    }
}
