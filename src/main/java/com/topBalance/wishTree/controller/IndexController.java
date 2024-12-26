package com.topBalance.wishTree.controller;


import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
//회원 가입
    @GetMapping("/register")
    public String register() {

        return "register";
    }
//가입 성공 페이지
    @PostMapping("/register-success")
    public String registerSuccess(@ModelAttribute("user") User user, Model model) {
        userService.insertUser(user);
        model.addAttribute("msg", "회원가입이 성공적으로 완료되었습니다.");
        return "success";
    }

    /**
     *
     * 로그인체크
     * @param userId
     * @return
     */
    @GetMapping("/checkPassword/{userId}")
    public String checkPassword(String userId){
        return "checkPassword";
    }

    /**
     *
     * 로그인체크
     * @param userId
     * @param model
     * @return
     */
    @PostMapping("/checkPassword/{userId}")




//회원정보 수정 작성페이지
    @GetMapping("/update/{userId}")
    public String updateUser(String userId, Model model) {
        User user = userService.updateUser(userId);
        model.addAttribute("user", user);
        return "update";
    }
}

