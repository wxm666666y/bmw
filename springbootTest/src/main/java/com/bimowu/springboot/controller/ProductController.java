package com.bimowu.springboot.controller;

import com.bimowu.springboot.model.Product;
import com.bimowu.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/4
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.listShowProduct();
    }

    @RequestMapping(value = "/queryItem", method = RequestMethod.GET)
    public Product query(Integer productId) {
        Product product = productService.findByProductId(productId);
        if (product != null) {
            return product;
        } else return new Product();
    }
}
