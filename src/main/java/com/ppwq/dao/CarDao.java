package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface CarDao {

  int addIntoCar(Car car);

  Page<Car> getCar(int uid);

  int deleteCar(int carid);

  int updateCar(Car car);

  int deleteOrderCar(@Param("params") Map<String, Object> params);
}
