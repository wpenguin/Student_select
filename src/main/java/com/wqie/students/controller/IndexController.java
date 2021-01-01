package com.wqie.students.controller;

import com.wqie.students.mapper.CoursesMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class IndexController {

    @Resource
    CoursesMapper coursesMapper;

    @RequestMapping("/index")
    public String index(){

        return "index";

    }

    @RequestMapping("sese")
    @ResponseBody
    public Object sese(){
        return coursesMapper.selectAll();
    }

}
