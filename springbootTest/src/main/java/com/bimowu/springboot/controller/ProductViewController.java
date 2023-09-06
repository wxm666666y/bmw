package com.bimowu.springboot.controller;

import com.bimowu.springboot.model.Product;
import com.bimowu.springboot.service.ProductService;
import com.bimowu.springboot.utils.bean.CommonQueryBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/5
 */
@Controller
@RequestMapping("/productview")
public class ProductViewController{

    @Autowired
    ProductService productService;

    @RequestMapping("/listProduct")
    public String listProduct(@RequestParam(value = "name",defaultValue = "") String name,
                              Model model,
                              @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "3") int pageSize){
        //设置商品名称,搜索
        Product record = new Product();
        if (StringUtils.isNotEmpty(name)) {
            record.setName(name);
            model.addAttribute("name", name);
        }

        //计算总数量
        long total = productService.count(record);
        //计算总页数
        int totalPageNum = (int)total / pageSize;
        if (total % pageSize > 0) totalPageNum ++;

        //分页相关参数
        CommonQueryBean query= new CommonQueryBean();
        query.setPageSize(pageSize);
        query.setPageNum(pageNum);
        query.setStart((pageNum-1) * pageSize);

        List<Product> list = productService.list4Page(record, query);

        model.addAttribute("total", total);
        model.addAttribute("totalPage", totalPageNum);
        model.addAttribute("list", list);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);

        return "index";
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    /**
     * 添加的方法
     * @param product
     * @param model
     * @return
     */
    @RequestMapping("/addProduct")
    public String listUser(Product product, Model model) {
        int result = productService.save(product);
        return "redirect:listProduct";
    }

    /**
     * 修改:回显数据
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String updateUser(Long id, Model model) throws Exception {
        Product product = productService.selectByPrimaryKey(id);
        model.addAttribute("product", product);
        return "update";
    }

    /**
     * 修改实际的业务逻辑
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateProduct")
    public String findUser(Product product) throws Exception {
        productService.updateItem(product);
        return "redirect:listProduct";
    }

    /**
     * 删除商品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(Long id) throws Exception {
        productService.deleteByPrimaryKey(id);
        return "redirect:listProduct";
    }

    /**
     * 产看商品详情
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/getProduct")
    public String getProduct(Long id, Model model) throws Exception {
        Product product = productService.selectByPrimaryKey(id);
        model.addAttribute("product", product);
        return "productShow";
    }

    @RequestMapping(value = "/queryByOrderNo", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> queryByOrderNo(String orderNo) {
        List<Product> list = productService.listByOrderNo(orderNo);
        //为了避免查询不出数据导致的返回数据空白
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<Product>();
        }
        return list;
    }
}
