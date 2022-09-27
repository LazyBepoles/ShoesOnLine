package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SalesController {

  @Autowired private SalesService salesService;

  @GetMapping("/hotbrand")
  public Map<String, Object> hotBrand(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));

    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.salesService.hotBrand());
    return result;
  }

  @GetMapping("/hottype")
  public Map<String, Object> hotType(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));

    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.salesService.hotType());
    return result;
  }

  @GetMapping("/hotcolor")
  public Map<String, Object> hotColor(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));

    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.salesService.hotColor());
    return result;
  }

  @GetMapping("/hotcommodity")
  public Map<String, Object> hotCommodity(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));

    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.salesService.hotCommodity());
    return result;
  }

  @GetMapping("/hotsize")
  public Map<String, Object> hotSize(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));

    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.salesService.hotSize());
    return result;
  }
}
