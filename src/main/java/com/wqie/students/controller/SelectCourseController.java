package com.wqie.students.controller;

import com.wqie.students.mapper.CoursesMapper;
import com.wqie.students.mapper.SelectCourseMapper;
import com.wqie.students.model.SelectCourse;
import com.wqie.students.model.SelectNoIn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SelectCourseController {

    @Resource
    SelectCourseMapper selectCourseMapper;

    @Resource
    CoursesMapper coursesMapper;

    @RequestMapping("/selectMySelectCourse")
    @ResponseBody
    public List<SelectCourse> selectMySelectCourse(Integer sno,Integer judge){

        if (judge == 0){
            return selectCourseMapper.selectMySelectCourse(sno);
        }else if(judge == 1){
            String semester = "一";
            return selectCourseMapper.selectMySelectCourseBySemester(sno,semester);
        }else{
            String semester = "二";
            return selectCourseMapper.selectMySelectCourseBySemester(sno,semester);
        }

    }

    @PostMapping("/insertIntoSelectCourse")
    public String insertIntoSelectCourse(String cno, HttpSession session, Model model){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int month = date.getMonth();
        String semester = "一";
        if(2<=month&&month<9){
            semester = "二";
        }
//        System.out.print(coursesMapper.selectCreditByCno(Integer.valueOf(cno)));
        if(selectCourseMapper.selectNoIn(new SelectNoIn((Integer) session.getAttribute("sno"),Integer.valueOf(cno),semester))==0){
            if(selectCourseMapper.selectSumByTno(coursesMapper.selectTnoByCno(Integer.valueOf(cno)),semester)<19){
                try {
                    selectCourseMapper.insert(new SelectCourse(selectCourseMapper.selectMaxId() + 1,
                            (Integer) session.getAttribute("sno"),
                            Integer.valueOf(cno),coursesMapper.selectTnoByCno(Integer.valueOf(cno)),semester,coursesMapper.selectCreditByCno(Integer.valueOf(cno))));
                }catch (Exception e){
                    if(e.getMessage().substring(65,71).equals("-20001")){
                        model.addAttribute("messages","同学期选课总学分不得超过19分！！！！！");
                        model.addAttribute("boolean","false");
                    }
                    return "index";
                }
                model.addAttribute("messages","选课成昆！！！！！");
                model.addAttribute("boolean","true");
                return "index";
            }else {
                model.addAttribute("messages","同学期此老师已有19个学生！！！！！");
                model.addAttribute("boolean","false");
                return "index";
            }
        }else {
            model.addAttribute("messages","同学期不能选相同课程！！！！！");
            model.addAttribute("boolean","false");
            return "index";
        }
    }//

    @PostMapping("/deleteMySelectCourse")
    public String deleteMySelectCourse(Integer cno, Integer judge, HttpSession session){

        if(judge==1){
            String semester = "一";
            selectCourseMapper.deleteMySelectCourse(new SelectNoIn((Integer) session.getAttribute("sno"),cno,semester));
            return "forward:/index";
        }else {
            String semester = "二";
            selectCourseMapper.deleteMySelectCourse(new SelectNoIn((Integer) session.getAttribute("sno"),cno,semester));
            return "index";
        }

    }


//    @RequestMapping("/test")
//    @ResponseBody
//    public String test(){
//        if(selectCourseMapper.selectNoIn(new SelectNoIn(2017133,55003,"一"))==1){
//            return "行！！！";
//        }
//        return "不行！！！";
//    }

}
