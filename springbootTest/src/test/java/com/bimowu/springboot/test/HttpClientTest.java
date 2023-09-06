package com.bimowu.springboot.test;

import com.bimowu.springboot.Application;
import com.bimowu.springboot.utils.http.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class HttpClientTest {
    @Autowired
    HttpClientUtil httpClientUtil;
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
