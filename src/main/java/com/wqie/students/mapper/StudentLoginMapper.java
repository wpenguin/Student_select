package com.wqie.students.mapper;

import com.wqie.students.model.StudentLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentLogin record);

    int insertSelective(StudentLogin record);

    StudentLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentLogin record);

    int updateByPrimaryKey(StudentLogin record);

    String selectPwdBySno(Integer sno);

    int selectBySno(Integer sno);
}