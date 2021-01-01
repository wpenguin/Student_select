package com.wqie.students.controller;

import com.wqie.students.mapper.StudentLoginMapper;
import com.wqie.students.model.StudentLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class StudentLoginController {

    @Resource
    StudentLoginMapper studentLoginMapper;

    @RequestMapping("/std")
    @ResponseBody
    public StudentLogin select(){
        return studentLoginMapper.selectByPrimaryKey(2);
    }

    @RequestMapping("/loging")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){

        httpSession.removeAttribute("sno");
        return "index";

    }

    @PostMapping("/login")
    public String select1(Integer sno, String pwd, HttpSession session, Model model){

        if(pwd.equals(studentLoginMapper.selectPwdBySno(sno))){
            session.setAttribute("sno",sno);
            return "index";
        }else if(null == studentLoginMapper.selectPwdBySno(sno)){
            model.addAttribute("serror","sno not exist");
            return "login";
        }else {
            model.addAttribute("perror","pwd error");
            return "login";
        }

    }

}
