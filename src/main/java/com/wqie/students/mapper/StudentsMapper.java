package com.wqie.students.mapper;

import com.wqie.students.model.Students;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    Students selectAllBySno(Integer sno);
}