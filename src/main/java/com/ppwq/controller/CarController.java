package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.pojo.Car;
import com.ppwq.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CarController {

  @Autowired private CarService carService;

  @PostMapping("/addintocar")
  public Map<String, Object> addIntoCar(@RequestBody Car car) {
    Map<String, Object> result = new HashMap<>();
    if (this.carService.addIntoCar(car) != 0) {
      result.put("code", 20000);
      result.put("msg", "Add Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Add Error");
    }
    return result;
  }

  @PostMapping("/updatecar")
  public Map<String, Object> updateCar(@RequestBody Car car) {
    Map<String, Object> result = new HashMap<>();
    if (this.carService.updateCar(car) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @GetMapping("/getcar")
  public Map<String, Object> getCar(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));
    int uid = Integer.parseInt((String) params.get("uid"));

    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.carService.getCar(uid));
    return result;
  }

  @PostMapping("/clearcar/{uid}")
  public Map<String, Object> deleteCar(@PathVariable int uid) {
    Map<String, Object> result = new HashMap<>();
    if (this.carService.deleteUserCar(uid) != 0) {
      result.put("code", 20000);
      result.put("msg", "Delete Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Delete Error");
    }
    return result;
  }

  @PostMapping("/deletecar/{carid}")
  public Map<String, Object> deleteUserCar(@PathVariable int carid) {
    Map<String, Object> result = new HashMap<>();
    if (this.carService.deleterCar(carid) != 0) {
      result.put("code", 20000);
      result.put("msg", "Delete Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Delete Error");
    }
    return result;
  }
}
