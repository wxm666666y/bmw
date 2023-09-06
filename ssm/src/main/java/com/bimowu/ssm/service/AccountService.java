package com.bimowu.ssm.service;

import com.bimowu.ssm.domain.Account;

import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/3
 */
public interface AccountService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 增加账户
     *
     * @param account
     */
    void addAccount(Account account);
}
