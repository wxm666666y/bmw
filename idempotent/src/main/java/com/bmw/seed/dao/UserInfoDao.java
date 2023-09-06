package com.bmw.seed.dao;

import org.springframework.stereotype.Repository;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/18
 */
@Repository
public interface UserInfoDao {

    /**
     * 进行模拟数据迁移将user_info_bak表的数据迁移到user_info表中
     */
    void transfer();

    /**
     * 统计user_info表中数据的数目
     * @return user_info表中数据的数目
     */
    int countTotal();
}
