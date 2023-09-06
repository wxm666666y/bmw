package com.bmw.seed.controller;

import com.bmw.seed.model.RegistReq;
import com.bmw.seed.service.UserRegistInfoService;
import com.bmw.seed.util.bean.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: han
 * @since: 2020-08-23 16:55
 **/
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

	@Autowired
	UserRegistInfoService userRegistInfoService;

	/**
	 * 注册
	 */
	@RequestMapping(value = "/regist")
	public BaseResponse<Boolean> regist(@Valid @RequestBody RegistReq req) {
		return BaseResponse.ok(userRegistInfoService.regist(req));
	}
}
