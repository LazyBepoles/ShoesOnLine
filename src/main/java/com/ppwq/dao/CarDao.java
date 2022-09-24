package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CarDao {

    int addIntoCar(Car car);

    Page<Car> getCar(int uid);

    int deleteCar(int carid);

    int updateCar(Car car);

}
