package com.bfs.logindemo.controller;

import com.bfs.logindemo.controller.vo.UserVo;
import com.bfs.logindemo.domain.User;
import com.bfs.logindemo.exception.UserNotFoundException;
import com.bfs.logindemo.service.UserService;
import com.bfs.logindemo.tools.CookieUtil;
import com.bfs.logindemo.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String defaultLogin(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(String name, String password, Model model, HttpServletResponse response) throws UserNotFoundException {
        User user = userService.getUserByNameAndPwd(name, password);
        //验证用户数据是否在库
        if(user==null){
            throw new UserNotFoundException("User " + name);
            //return  "Invalid username or password!";
        }
        //String jwtToken = JwtUtil.getJwtToken(String.valueOf(user.getId()),user.getUsername());
        String jwtToken = JwtUtil.generateToken(user.getName());
        CookieUtil.create(response, JwtUtil.JWT_TOKEN_COOKIE_NAME, jwtToken, false, -1, "localhost");
        return "redirect:book";
    }


    @GetMapping("/clear")
    public void clearLogin(@RequestParam String name, Model model, HttpServletResponse response){
        CookieUtil.clear(response, name);
    }
}
