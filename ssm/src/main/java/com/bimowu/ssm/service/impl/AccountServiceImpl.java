package com.bimowu.ssm.service.impl;

import com.bimowu.ssm.dao.AccountDao;
import com.bimowu.ssm.domain.Account;
import com.bimowu.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/3
 */
//相当于bean标签里面的id
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    /**
     * 查询所有
     *
     * @return
     */
    public List<Account> findAll() {
        System.out.println("业务层的findAll");
        return accountDao.findAll();
    }

    /**
     * 增加账户
     *
     * @param account
     */
    public void addAccount(Account account) {
        System.out.println("业务层：保存账户");
        accountDao.addAccount(account);
    }
}
