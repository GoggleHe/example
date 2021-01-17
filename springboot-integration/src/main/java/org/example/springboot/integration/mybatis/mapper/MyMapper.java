package org.example.springboot.integration.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMapper {

    @Select("select USE_ID from USER")
    List<Integer> selectOne();
}
