package com.wqie.students.controller;

import com.wqie.students.mapper.StudentsMapper;
import com.wqie.students.model.Students;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class StudentsController {

    @Resource
    StudentsMapper studentsMapper;

    @RequestMapping("/selectMyInformation")
    @ResponseBody
    public Students selectMyInformation(Integer sno){
        return studentsMapper.selectAllBySno(sno);
    }

}
