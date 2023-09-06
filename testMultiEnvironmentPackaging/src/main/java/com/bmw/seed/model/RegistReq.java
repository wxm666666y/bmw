package com.bmw.seed.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: han
 * @since: 2020-08-23 17:16
 **/
public class RegistReq implements Serializable {

	@NotBlank(message = "手机号 不能为空")
	private String phone;
	@NotBlank(message = "密码 不能为空")
	private String password;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
