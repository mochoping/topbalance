package com.topBalance.wishTree.controller;


import com.topBalance.wishTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        List<Map<String, Object>> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }


}

