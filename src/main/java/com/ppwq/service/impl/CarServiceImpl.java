package com.ppwq.service.impl;

import com.github.pagehelper.Page;
import com.ppwq.dao.CarDao;
import com.ppwq.pojo.Car;
import com.ppwq.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarServiceImpl implements CarService {

  @Autowired private CarDao carDao;

  @Override
  public int addIntoCar(Car car) {
    car.setCreateTime(new Date());
    return this.carDao.addIntoCar(car);
  }

  @Override
  public Page<Car> getCar(int uid) {
    return this.carDao.getCar(uid);
  }

  @Override
  public int deleteCar(int carid) {
    return this.deleteCar(carid);
  }

  @Override
  public int updateCar(Car car) {
    return this.carDao.updateCar(car);
  }
}
