package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.pojo.Size;
import com.ppwq.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SizeController {

  @Autowired private SizeService sizeService;

  @PostMapping("/addsize")
  public Map<String, Object> addSize(@RequestBody Size size) {
    Map<String, Object> result = new HashMap<>();
    if (this.sizeService.addNewSize(size) != 0) {
      result.put("code", 20000);
      result.put("msg", "Insert Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Insert Error");
    }
    return result;
  }

  @PostMapping("/deletesize/{sid}")
  public Map<String, Object> deleteSize(@PathVariable int sid) {
    Map<String, Object> result = new HashMap<>();
    if (this.sizeService.deleteSize(sid) != 0) {
      result.put("code", 20000);
      result.put("msg", "Delete Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Delete Error");
    }
    return result;
  }

  @GetMapping("/getsize")
  public Map<String, Object> searchSizeByPage(@RequestParam Map<String, Object> params) {
    int pageNum = Integer.parseInt((String) params.get("pageNum"));
    int pageSize = Integer.parseInt((String) params.get("pageSize"));

    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.sizeService.getAllSize());
    return result;
  }
}
