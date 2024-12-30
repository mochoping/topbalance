package com.topBalance.wishTree.controller;


import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.mapper.UserMapper;
import com.topBalance.wishTree.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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
        return "register-success";
    }

    /**
     * 로그인
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * 로그인체크
     *
     * @param userId
     * @param userPassword
     * @param model
     * @return
     */
    @PostMapping("login")
    public String login(@RequestParam String userId,
                        @RequestParam String userPassword,
                        Model model,
                        HttpSession session) {
        User user = userService.login(userId, userPassword);

        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/";
        }
        else {
            model.addAttribute("fail","아이디나 비밀번호가 일치하지 않습니다.");
            return "login";
        }
    }
    @ModelAttribute("loggedInUser")
    public Object addLoggedInUser(HttpSession session) {
        return session.getAttribute("loggedInUser");
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/mypage")
    public String myPage(Model model, HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
        }
        return "mypage";
    }

    //회원정보 수정 작성페이지
    @GetMapping("/update")
    public String update(Model model, HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
            return "/update";
        } else {
            return "redirect:/login";
        }

    }
    /*public String updateUser(@PathVariable String userId, Model model) {
        User user = userService.updateUser(userId);
        model.addAttribute("user", user);
        return "update";
    }*/
    @PostMapping("/update-success")
    public String updateSuccess(@ModelAttribute("user") User user, Model model) {
        userService.updateUser(user);
        model.addAttribute("msg", "정보수정이 성공적으로 완료되었습니다.");
        return "update-success";
    }

    @GetMapping("/find-password")
    public String findByPassword() {

        return "find-password";
    }


    @GetMapping("/find-password-result")
    public String findByPassword(@RequestParam String userId,
                                 @RequestParam String userPhone,
                                 Model model) {
        String password = userService.findByPassword(userId, userPhone);
        model.addAttribute("password", password);
        return "find-password-result";
    }

    @GetMapping("/find-id")
    public String findById(String userName, String userPhone, Date userBirthdate) {
        return "find-id";
    }

    @GetMapping("/find-id-result")
    public String findById(@RequestParam String userName,
                           @RequestParam String userPhone,
                           @RequestParam Date userBirthdate,
                           Model model) {
        String findID = userService.findById(userName, userPhone, userBirthdate);
        model.addAttribute("userId", findID);
        return "find-id-result";
    }

}

