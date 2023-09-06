package com.bimowu.ssm.controller;

import com.bimowu.ssm.domain.Account;
import com.bimowu.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/3
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("findAll方法执行了！！！");
        accountService.findAll();
        List<Account> all = accountService.findAll();
        System.out.println(all);
        model.addAttribute("list",all);
        return "show";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(123);
        accountService.addAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}
