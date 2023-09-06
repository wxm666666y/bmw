package com.bimowu.ssm.dao;

import com.bimowu.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/3
 */
@Repository
public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 增加账户
     * @param account
     */
    @Insert("insert into account(name,money) values (#{name}, #{money})")
    void addAccount( Account account );
}
