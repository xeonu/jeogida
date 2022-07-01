package com.godofparking.jeogida.mapper;

import com.godofparking.jeogida.domain.ParkingLot;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkingLotMapper {
    @Insert("INSERT INTO parking_lot(number, location_id, map_id) VALUES(#{parking_lot.number}, #{parking_lot.location_id}, #{parking_lot.map_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("parking_lot") ParkingLot parking_lot);

    @Select("SELECT * FROM parking_lot WHERE id=#{id}")
    @Results(id="ParkingLotMap", value={
            @Result(property="id", column="id"),
            @Result(property="number", column="number"),
            @Result(property="location_id", column="location_id"),
            @Result(property="map_id", column = "map_id")
    })
    ParkingLot getById(@Param("id") int id);

    @ResultMap("ParkingLotMap")
    @Select("SELECT * FROM parking_lot")
    List<ParkingLot> getAll();

    @Delete("DELETE FROM parking_lot WHERE id = #{id}")
    int deleteParkingLot(@Param("id") int id);
}
