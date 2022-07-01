package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMapper {
    @Insert("INSERT INTO car(number, name, user_id) VALUES(#{car.number}, #{car.name}, #{car.user_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("car") Car car);

    @Select("SELECT * FROM car WHERE id=#{id}")
    @Results(id="CarMap", value={
            @Result(property="id", column="id"),
            @Result(property="number", column="number"),
            @Result(property="name", column="nicknamename")
    })
    Car getById(@Param("id") int id);

    @ResultMap("CarMap")
    @Select("SELECT * FROM car")
    List<Car> getAll();

    @Delete("DELETE FROM car WHERE id = #{id}")
    int deleteCar(@Param("id") int id);
}
