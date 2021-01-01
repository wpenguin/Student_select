package com.wqie.students.mapper;

import com.wqie.students.model.SelectCourse;
import com.wqie.students.model.SelectNoIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SelectCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectCourse record);

    int insertSelective(SelectCourse record);

    SelectCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectCourse record);

    int updateByPrimaryKey(SelectCourse record);

    List<SelectCourse> selectMySelectCourse(Integer sno);

    List<SelectCourse> selectMySelectCourseBySemester(@Param("sno")Integer sno, @Param("semester")String semester);

    Integer selectMaxId();

    Integer selectNoIn(SelectNoIn selectNoIn);

    Integer deleteMySelectCourse(SelectNoIn selectNoIn);

    Integer selectSumByTno(@Param("tno") Integer tno,@Param("semester")String semester);
}