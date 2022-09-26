package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.pojo.Type;
import com.ppwq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TypeController {

  @Autowired private TypeService typeService;

  @PostMapping("/addtype")
  public Map<String, Object> addType(@RequestBody Type type) {
    Map<String, Object> result = new HashMap<>();
    if (this.typeService.addNewType(type) != 0) {
      result.put("code", 20000);
      result.put("msg", "Insert Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Insert Error");
    }
    return result;
  }

  @PostMapping("/updatetype")
  public Map<String, Object> updateType(@RequestBody Type type) {
    Map<String, Object> result = new HashMap<>();
    if (this.typeService.updateType(type) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @GetMapping("/searchtype")
  public Map<String, Object> searchTypeByName(@RequestBody Map<String,Object> params) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.typeService.searchTypeByName((String) params.get("name")));
    return result;
  }

  @GetMapping("/searchtype/{id}")
  public Map<String, Object> searchTypeById(@PathVariable int id) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.typeService.searchTypeById(id));
    return result;
  }

  @GetMapping("/gettype")
  public Map<String, Object> searchTypeByPage(@RequestBody Map<String,Integer> params) {
    PageHelper.startPage(params.get("pageNum"),params.get("pageSize"));
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.typeService.searchTypeByPage());
    return result;
  }

  @PostMapping("/updatetypestatus")
  public Map<String, Object> updateStatus(@RequestBody Map<String, Integer> params){
    Map<String, Object> result = new HashMap<>();
    if (this.typeService.updateTypeStatus(params.get("status"),params.get("tid"))!=0){
      result.put("code", 20000);
      result.put("msg", "Update Success");
    }else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @GetMapping("/getalltype")
  public Map<String, Object> searchTypeByPage() {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.typeService.searchAllType());
    return result;
  }
}
