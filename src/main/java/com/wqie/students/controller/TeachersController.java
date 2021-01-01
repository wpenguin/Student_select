package com.wqie.students.controller;

import com.wqie.students.mapper.TeachersMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TeachersController {

    @Resource
    TeachersMapper teachersMapper;

    @PostMapping("/selectTnameByTno")
    @ResponseBody
    public String selectTnameByTno(Integer tno){
        return teachersMapper.selectTnameByTno(tno);
    }

}
