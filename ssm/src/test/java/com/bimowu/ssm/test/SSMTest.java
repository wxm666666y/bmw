package com.bimowu.ssm.test;

import com.bimowu.ssm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/3
 */
public class SSMTest {

    @Test
    public void springTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService =  (AccountService) ac.getBean("accountService");
        accountService.findAll();
    }

}
