package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.FavoriteLocation;
import com.godofparking.jeogida.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavoriteLocationMapper {
    @Insert("INSERT INTO favorite_location(user_id, location_id) VALUES(#{favorite_location.user_id}, #{favorite_location.location_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("favorite_location") FavoriteLocation favorite_location);

    @Select("SELECT * FROM favorite_location WHERE id=#{id}")
    @Results(id="FavoriteLocationMap", value={
            @Result(property="id", column="id"),
            @Result(property="user_id", column="user_id"),
            @Result(property="location_id", column="location_id"),
    })
    FavoriteLocation getById(@Param("id") int id);

    @ResultMap("FavoriteLocationMap")
    @Select("SELECT * FROM favorite_location")
    List<FavoriteLocation> getAll();

    @Delete("DELETE FROM favorite_location WHERE id = #{id}")
    int deleteFavoriteLocation(@Param("id") int id);

}
