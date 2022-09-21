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

  @GetMapping("/getcar")
  public Map<String, Object> getCar(@RequestBody Map<String, Object> params) {
    PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.carService.getCar((Integer) params.get("uid")));
    return result;
  }

  @PostMapping("/deletecar/{id}")
  public Map<String, Object> getCar(@PathVariable int id) {
    Map<String, Object> result = new HashMap<>();
    if (this.carService.deleteCar(id) != 0) {
      result.put("code", 20000);
      result.put("msg", "Delete Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Delete Error");
    }
    return result;
  }
}
