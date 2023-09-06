package com.bimowu.springboot.dao;

import java.util.List;
import com.bimowu.springboot.model.Account;
import com.bimowu.springboot.utils.bean.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Account数据库操作接口类
 * 
 **/

@Repository
public interface AccountDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Account  selectByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( Account record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Account record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Account> list4Page ( Account record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count ( Account record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Account> list ( Account record);

}