package com.wxblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: NightWish
 * @create: 2018-09-21 17:14
 * @description:
 **/

@Controller
public class BaseController {

    @GetMapping(value = "/login")
    public String loginPage(String loginName,String password,Model model){
        return "admin/login";
    }

}
