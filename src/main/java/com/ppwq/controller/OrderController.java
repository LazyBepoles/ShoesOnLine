package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public Map<String, Object> searchOrder(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));

    if (params.get("orderBy") != null) {
      PageHelper.startPage(pageNum, pageSize, (String) params.get("orderBy"));
    } else {
      PageHelper.startPage(pageNum, pageSize);
    }
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.orderService.searchOrder(params));
    return result;
  }

  @PostMapping("/updateorder")
  public Map<String, Object> updateOrder(@RequestBody Map<String, Object> params) {
    Map<String, Object> result = new HashMap<>();
    if (this.orderService.updateOrderStatus(params) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }

    return result;
  }

  @GetMapping("/getorderdetail/{oid}")
  public Map<String, Object> getDetail(@PathVariable int oid) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.orderService.getDetail(oid));
    return result;
  }

  //  @GetMapping("/getnosend")
  //  public Map<String, Object> getNoSend(@RequestBody Map<String, Object> params) {
  //    PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
  //    Map<String, Object> result = new HashMap<>();
  //    result.put("code", 20000);
  //    result.put("msg", "Search Success");
  //    result.put("data", this.orderService.noSendOrder());
  //    return result;
  //  }
  //
  //  @GetMapping("/getrefund")
  //  public Map<String, Object> getRefund(@RequestBody Map<String, Object> params) {
  //    PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
  //    Map<String, Object> result = new HashMap<>();
  //    result.put("code", 20000);
  //    result.put("msg", "Search Success");
  //    result.put("data", this.orderService.refund());
  //    return result;
  //  }

}
