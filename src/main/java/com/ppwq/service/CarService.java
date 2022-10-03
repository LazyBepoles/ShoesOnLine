package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Car;

public interface CarService {

    int addIntoCar(Car car);

    Page<Car> getCar(int uid);

    int deleteUserCar(int uid);

    int deleterCar(int carid);

    int updateCar(Car car);
}
