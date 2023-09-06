package com.bmw.seed.service.impl;

import com.bmw.seed.dao.UserInfoDao;
import com.bmw.seed.service.UserInfoService;
import com.bmw.seed.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/18
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 进行模拟数据迁移将user_info_bak表的数据迁移到user_info表中
     * @return 迁移成功返回true,否则返回false
     */
    //没有进行幂等性校验
//    @Override
//    public Boolean transfer() {
//        int bak = userInfoDao.countTotal();
//        System.out.println("===[迁移前,user_info表中数据为{" + bak +"}条]===");
//        System.out.println("===[开始transfer()方法]===");
//        userInfoDao.transfer();
//        int count = userInfoDao.countTotal();
//        System.out.println("===[迁移完成,user_info表中数据为{" + count +"}条]===");
//        if( count > 0 ){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    /**
     * 进行模拟数据迁移将user_info_bak表的数据迁移到user_info表中
     * @return 迁移成功返回true,否则返回false
     */
    @Override
    public Boolean transfer() {
        int beforeCount = userInfoDao.countTotal();
        System.out.println("===[迁移前,user_info表中数据为{" + beforeCount +"}条]===");
        if( beforeCount > 0 ){
            System.out.println("===[业务逻辑校验失败:user_info表中已经有数据,本次操作直接返回失败]===");
            return false;
        }
        System.out.println("===[开始transfer()方法]===");
        userInfoDao.transfer();
        int count = userInfoDao.countTotal();
        System.out.println("===[迁移完成,user_info表中数据为{" + count +"}条]===");
        if( count > 0 ){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 幂等校验
     * @return
     */
    @Override
    public Boolean transferExpand() {
        System.out.println("===[开始使用幂等性校验进行迁移]===");
        String token = "transfer";
        if( !redisUtil.set(token, 1) ){
            //如果存在,则返回失败
            System.out.println("===[重复执行api,直接返回失败]===");
        }
        else{
            try {
                return transfer();
            }catch ( Exception e ){
                e.printStackTrace();
                return false;
            }
            finally {
                redisUtil.del(token);
            }
        }
        return null;
    }

    /**
     * 统计user_info表中数据的数目
     * @return user_info表中数据的数目
     */
    @Override
    public int countTotal() {
        return userInfoDao.countTotal();
    }
}
