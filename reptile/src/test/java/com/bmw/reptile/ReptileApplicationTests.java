package com.bmw.reptile;

import com.bmw.reptile.dao.InformationDao;
import com.bmw.reptile.utils.http.HttpClientUtil;
import com.bmw.reptile.utils.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ReptileApplication.class)
public class ReptileApplicationTests {

    @Autowired
    InformationDao informationDao;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    HttpClientUtil httpClientUtil;

    @Test
    public void contextLoads() {
        int n = informationDao.selectBySingleTag("abdea4bb2d9aa5f4db2184b29d7d1ec2");
        System.out.println(n);
    }

    @Test
    public void contextLoads2() {
        System.out.println(redisUtil.get("k1"));
    }

    @Test
    public void test() {
        try {
            String str = httpClientUtil.doGet("http://www.baidu.com");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
