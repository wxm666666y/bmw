package com.bmw.seed.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.bmw.seed.dao.UserRegistInfoDao;
import com.bmw.seed.model.RegistReq;
import com.bmw.seed.model.UserRegistInfo;
import com.bmw.seed.service.UserRegistInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: han
 * @since: 2020-08-23 17:00
 **/
@Service
@Slf4j
public class UserRegistInfoServiceImpl implements UserRegistInfoService {
	@Autowired
	UserRegistInfoDao userRegistInfoDao;


	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean regist(RegistReq req) {
		//悲观锁
		UserRegistInfo registInfo = userRegistInfoDao.fetchByPhoneForUpdate(req.getPhone());
		if (registInfo != null) {
			//手机号已经被注册
			log.error("===[手机号已被注册！]===");
			return false;
		} else {
			Date date = new Date();
			UserRegistInfo info = new UserRegistInfo();
			BeanUtils.copyProperties(req, info);
			info.setPassword(DigestUtil.md5Hex(info.getPassword()));
			info.setCreateTime(date);
			info.setUpdateTime(date);
			int i = userRegistInfoDao.insert(info);
			return i > 0;
		}
	}
}
