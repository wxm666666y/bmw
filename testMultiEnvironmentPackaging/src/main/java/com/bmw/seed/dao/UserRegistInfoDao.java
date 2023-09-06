package com.bmw.seed.dao;

import com.bmw.seed.model.UserRegistInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistInfoDao {

	UserRegistInfo fetchByPhoneForUpdate(String phone);

	int insert(UserRegistInfo userRegistInfo);
}
