package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

  @Autowired private OrderService orderService;

  @PostMapping("/addorder")
  public Map<String, Object> addOrder(@RequestBody Map<String, Object> params) {
    Map<String, Object> result = new HashMap<>();
    if (this.orderService.addNewOrder(params) != 0) {
      result.put("code", 20000);
      result.put("msg", "Insert Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Error Success");
    }
    return result;
  }

  @GetMapping("/searchorder")
  public Map<String, Object> searchOrder(@RequestBody Map<String, Object> params) {
    PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data",this.orderService.searchOrder((Integer) params.get("uid"),(Integer) params.get("status")));
    return result;
  }
}
