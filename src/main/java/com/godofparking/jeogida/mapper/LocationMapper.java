package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.Location;
import com.godofparking.jeogida.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LocationMapper {

    @Insert("INSERT INTO location(name, total) VALUES(#{location.name}, #{location.total})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("location") Location location);

    @Select("SELECT * FROM location WHERE id=#{id}")
    @Results(id="LocationMap", value={
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="total", column="total"),
    })
    Location getById(@Param("id") int id);

    @ResultMap("LocationMap")
    @Select("SELECT * FROM location")
    List<Location> getAll();

    @Delete("DELETE FROM location WHERE id = #{id}")
    int deleteLocation(@Param("id") int id);

}
