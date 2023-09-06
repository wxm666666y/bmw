package com.bmw.reptile.dao;

import java.util.List;
import com.bmw.reptile.model.Information;
import com.bmw.reptile.utils.bean.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Information数据库操作接口类
 * 
 **/

@Repository
public interface InformationDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Information  selectByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( Information record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Information record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Information> list4Page ( Information record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count ( Information record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Information> list ( Information record);

	/**
	 * 根据标题进行模糊查询
	 * @param word
	 * @return
	 */
	List<Information> findLikeInfo( String word );

	/**
	 * 通过数据库来判断插入新数据,排除旧数据
	 * @param info
	 */
	void insertIfNotExist(Information info);

	int  selectBySingleTag ( @Param("singleTag") String singleTag );
}