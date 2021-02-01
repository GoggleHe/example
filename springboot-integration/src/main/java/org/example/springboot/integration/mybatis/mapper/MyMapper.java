package org.example.springboot.integration.mybatis.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheNamespace()
public interface MyMapper {

    @Select("select USE_ID from USER")
    List<Integer> selectOne();

    @Update("update user set use_name = #{name1} where use_id = #{id1};" +
            "update user set use_name = #{name2} where use_id = #{id2};")
    int updateMulti(@Param("id1") Integer id1, @Param("name1") String name1, @Param("id2") Integer id2, @Param("name2") String name2);
}
