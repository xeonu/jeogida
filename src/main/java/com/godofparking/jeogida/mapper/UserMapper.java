package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id = #{id}")
    User getUser(@Param("id") Integer id);

    @Insert("insert into  user values(#{id}, #{email}, #{nickname}, #{password}, #{createdAt}, #{updatedAt}")
    User createUser(@Param("id") Integer id, @Param("email") String email, @Param("nickname") String nickname, @Param("password") String password, @Param("createdAt") Date createdAt, @Param("updatedAt")Date updatedAt);

    @Update("update user set name = #{name} where id = #{id}")
    User updateUser(@Param("name") String name, @Param("id") Integer id);

    @Delete("delete from user where id = #{id}")
    User deleteUser(@Param("id") Integer id);
}
