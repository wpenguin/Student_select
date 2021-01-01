package com.wqie.students.mapper;

import com.wqie.students.model.Teachers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeachersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);

    String selectTnameByTno(Integer tno);
}