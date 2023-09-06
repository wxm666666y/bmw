package com.bmw.seed.service;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/18
 */
public interface UserInfoService {

    /**
     * 进行模拟数据迁移将user_info_bak表的数据迁移到user_info表中
     * @return 迁移成功返回true,否则返回false
     */
    Boolean transfer();

    /**
     * 幂等校验,进行模拟数据迁移将user_info_bak表的数据迁移到user_info表中
     * @return 迁移成功返回true,否则返回false
     */
    Boolean transferExpand();

    /**
     * 统计user_info表中数据的数目
     * @return user_info表中数据的数目
     */
    int countTotal();
}
