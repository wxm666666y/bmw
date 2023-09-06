package com.bimowu.springboot.service;

import com.bimowu.springboot.model.Product;
import com.bimowu.springboot.utils.bean.CommonQueryBean;

import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/4
 */
public interface ProductService {

    /**
     * 查询全部的商品信息.
     */
    List<Product> listShowProduct();

    /**
     * 根据productId查询商品信息.
     */
    Product findByProductId(Integer productId);

    List<Product> list4Page ( Product record, CommonQueryBean query);

    long count(Product product);

    /**
     * 添加
     * @param record
     * @return
     */
    int save(Product record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateItem(Product record);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product selectByPrimaryKey(Long id);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    List<Product> listByOrderNo(String orderNo);
}
