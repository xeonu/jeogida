package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(email, nickname, password) VALUES(#{user.email}, #{user.nickname}, #{user.password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("user") User user);

    @Select("SELECT * FROM user WHERE id=#{id}")
    @Results(id="UserMap", value={
            @Result(property="id", column="id"),
            @Result(property="email", column="email"),
            @Result(property="nickname", column="nickname"),
            @Result(property="password", column="password")
    })
    User getById(@Param("id") int id);

    @ResultMap("UserMap")
    @Select("SELECT * FROM user")
    List<User> getAll();

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteUser(@Param("id") int id);

    //구현실패
    @Update("UPDATE user SET nickname = #{nickname} WHERE id = #{id}")
    int updateUserNickname( @Param("id") int id, @Param("nickname") String nickname);

}
