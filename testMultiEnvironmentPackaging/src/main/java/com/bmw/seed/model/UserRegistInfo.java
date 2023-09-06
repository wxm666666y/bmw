package com.bmw.seed.model;

import java.io.Serializable;
import java.util.Date;

/**
 * user_regist_info
 *
 * @author: han
 * @since: 2020-08-23 17:03
 **/
public class UserRegistInfo implements Serializable {
	private Long id;
	private String phone;
	private String password;
	private Date createTime;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
