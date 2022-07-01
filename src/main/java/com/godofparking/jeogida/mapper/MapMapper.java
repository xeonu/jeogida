package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.Map;
import com.godofparking.jeogida.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MapMapper {
    @Insert("INSERT INTO map(name, path) VALUES(#{map.name}, #{map.path})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("map") Map map);

    @Select("SELECT * FROM map WHERE id=#{id}")
    @Results(id="MapMap", value={
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="total", column="total"),
    })
    Map getById(@Param("id") int id);

    @ResultMap("MapMap")
    @Select("SELECT * FROM map")
    List<Map> getAll();

    @Delete("DELETE FROM map WHERE id = #{id}")
    int deleteMap(@Param("id") int id);

}
