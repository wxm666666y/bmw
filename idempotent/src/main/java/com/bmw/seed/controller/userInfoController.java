package com.bmw.seed.controller;

import com.bmw.seed.service.UserInfoService;
import com.bmw.seed.util.bean.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/demo")
@Slf4j
public class userInfoController {

	@Autowired
	UserInfoService userInfoService;

	/**
	 * 迁移需求
	 */
	@RequestMapping("/transfer")
	public BaseResponse<Boolean> tranfer(){
		return BaseResponse.OK( userInfoService.transfer() );
	}

	/**
	 * 迁移需求
	 */
	@RequestMapping("/transferExpand")
	public BaseResponse<Boolean> tranferExpand(){
		return BaseResponse.OK( userInfoService.transferExpand() );
	}


}
