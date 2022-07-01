package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.ParkingInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkingInfoMapper {
    @Insert("INSERT INTO parking_info(number, is_parked, parking_lot_id) VALUES(#{parking_info.number}, #{parking_info.is_parked}, #{parking_info.parking_lot_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("parking_info") ParkingInfo parking_info);

    @Select("SELECT * FROM parking_info WHERE id=#{id}")
    @Results(id="ParkingInfoMap", value={
            @Result(property="id", column="id"),
            @Result(property="number", column="number"),
            @Result(property="is_parked", column="is_parked"),
            @Result(property = "parking_lot_id", column = "parking_lot_id")
    })
    ParkingInfo getById(@Param("id") int id);

    @ResultMap("ParkingInfoMap")
    @Select("SELECT * FROM parking_info")
    List<ParkingInfo> getAll();

    @Delete("DELETE FROM parking_info WHERE id = #{id}")
    int deleteParkingInfo(@Param("id") int id);
}
