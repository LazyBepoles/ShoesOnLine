package com.ppwq.controller;

import com.ppwq.pojo.User;
import com.ppwq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

  @Autowired private AdminService adminService;
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
  String nowTime = sdf.format(date);
  Date time = sdf.parse(nowTime);

  public AdminController() throws ParseException {}

  @PostMapping("/updateRole/{uid}/{role}")
  public Map<String, Object> updateRole(
      @PathVariable("uid") int uid, @PathVariable("role") int role) {
    Map<String, Object> result = new HashMap<>();
    if (this.adminService.updateRole(uid, role) != 0) {
      result.put("code", 50000);
      result.put("msg", "修改成功");
    } else {
      result.put("code", 20000);
      result.put("msg", "修改失败");
    }
    return result;
  }

  @PostMapping("/updatePurview/{uid}/{purview}")
  public Map<String, Object> updatePurview(
      @PathVariable("uid") int uid, @PathVariable("purview") int purview) {
    Map<String, Object> result = new HashMap<>();
    if (this.adminService.updatePurview(uid, purview) != 0) {
      result.put("code", 50000);
      result.put("msg", "修改成功");
    } else {
      result.put("code", 20000);
      result.put("msg", "修改失败");
    }
    return result;
  }

  @PostMapping("/insertAdmin")
  public Map<String, Object> insertAdmin(@RequestPart("req") User admin) {
    Map<String, Object> result = new HashMap<>();
    if (this.adminService.insertAdmin(admin, time) != 0) {
      result.put("code", 50000);
      result.put("msg", "添加成功");
    } else {
      result.put("code", 20000);
      result.put("msg", "添加失败");
    }
    return result;
  }

  @GetMapping("/queryAdmin/{uid}")
  public Map<String, Object> queryAdmin(@PathVariable("uid") int uid) {
    Map<String, Object> result = new HashMap<>();
    result.put("data", this.adminService.queryAdmin(uid));
    return result;
  }

  @GetMapping("/getAllAdmin")
  public Map<String, Object> getAll() {
    Map<String, Object> result = new HashMap<>();
    result.put("data", this.adminService.getAllAdmin());
    return result;
  }
}
