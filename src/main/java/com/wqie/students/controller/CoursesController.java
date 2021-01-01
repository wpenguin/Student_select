package com.wqie.students.controller;

import com.wqie.students.mapper.CoursesMapper;
import com.wqie.students.mapper.SelectCourseMapper;
import com.wqie.students.model.Courses;
import com.wqie.students.model.SelectCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CoursesController {

    @Resource
    CoursesMapper coursesMapper;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Courses> selectAll(){
        return coursesMapper.selectAll();
    }

    @PostMapping("/selectSumCreditBySno")
    @ResponseBody
    public Integer selectSumCreditBySno(Integer sno,Integer judge){

        if (judge == 0){
            return coursesMapper.selectSumCreditBySno(sno);
        }else if(judge == 1){
            String semester = "一";
            return coursesMapper.selectSumCreditBySnoAndSemester(sno,semester);
        }else{
            String semester = "二";
            return coursesMapper.selectSumCreditBySnoAndSemester(sno,semester);
        }

    }

    @PostMapping("/selectCnameByCno")
    @ResponseBody
    public String selectCnameByCno(Integer cno){
        return coursesMapper.selectCnameByCno(cno);
    }


}
