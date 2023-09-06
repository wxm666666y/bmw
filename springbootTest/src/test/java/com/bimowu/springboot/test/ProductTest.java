package com.bimowu.springboot.test;

import com.bimowu.springboot.Application;
import com.bimowu.springboot.dao.ProductDao;
import com.bimowu.springboot.model.Product;
import com.bimowu.springboot.service.ProductService;
import com.bimowu.springboot.utils.bean.CommonQueryBean;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductTest {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductService productService;

    @Test
    public void testQuery() {
        Product record = new Product();
        record.setState(1);
        List<Product> list = productDao.list(record);
        System.out.println(list.size());
    }

    @Test
    public void testInsert() {
        Product product1 = new Product();
        product1.setCreateTime(new Date());
        product1.setDesc("本商品使用起来体验非常好");
        product1.setName("电吹风");
        product1.setPrice(BigDecimal.valueOf(1100));
        product1.setProductId(1000111L);
        product1.setState(1);
        productDao.insert(product1);
        //保存成功会把自增主键id返回回来
        System.out.println(product1.getId());
        Product product2 = new Product();
        product2.setCreateTime(new Date());
        product2.setDesc("本洗衣机带烘干功能");
        product2.setName("洗衣机");
        product2.setPrice(BigDecimal.valueOf(1100));
        product2.setProductId(1000222L);
        product2.setState(1);
        productDao.insert(product2);
        //保存成功会把自增主键id返回回来
        System.out.println(product2.getId());
    }

    @Test
    public void testPage(){
        Product record = new Product();
        record.setState(1);

        int pageSize = 3, pageNum = 1;

        //计算总数量
        long total = productDao.count(record);
        //计算总页数
        int totalPageNum = (int)total / pageSize;
        if (total % pageSize > 0) totalPageNum ++;

        //分页相关参数
        CommonQueryBean query= new CommonQueryBean();
        query.setPageSize(pageSize);
        query.setPageNum(pageNum);
        query.setStart((pageNum-1) * pageSize);

        List<Product> list = productDao.list4Page(record, query);

//        List<Product> list = productDao.list4Page(record);
//        List<Product> list = productDao.list(record);
        System.out.println(list);
    }

    @Test
    public void testOrder(){
        List<Product> list = productService.listByOrderNo("a20191107b");
        //为了避免查询不出数据导致的返回数据空白
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<Product>();
        }
        System.out.println(list);
    }
}
