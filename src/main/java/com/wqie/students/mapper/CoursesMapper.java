package com.wqie.students.mapper;

import com.wqie.students.model.Courses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CoursesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Courses record);

    int insertSelective(Courses record);

    Courses selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Courses record);

    int updateByPrimaryKey(Courses record);

    List<Courses> selectAll();

    Integer selectTnoByCno(Integer cno);

    Integer selectSumCreditBySno(Integer sno);

    Integer selectSumCreditBySnoAndSemester(@Param("sno")Integer sno, @Param("semester")String semester);

    Integer selectCreditByCno(Integer cno);

    String selectCnameByCno(Integer cno);
}