package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.pojo.User;
import com.ppwq.service.UserService;
import com.ppwq.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

  @Autowired private UserService userService;

  @GetMapping("/getuser")
  public Map<String, Object> getUser(@RequestBody Map<String, Integer> params) {
    PageHelper.startPage(params.get("pageNum"), params.get("pageSize"));
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.userService.searchUserByPage());
    return result;
  }

  @GetMapping("/searchuser")
  public Map<String, Object> searchUser(@RequestBody Map<String, Object> params) {
    PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.userService.searchUser(params));
    return result;
  }

  @GetMapping("/searchuser/{id}")
  public Map<String, Object> getUser(@PathVariable int id) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.userService.searchUserById(id));
    return result;
  }

  @PostMapping("/updateuser")
  public Map<String, Object> updateUser(@RequestBody User user) {
    Map<String, Object> result = new HashMap<>();
    if (this.userService.updateUser(user) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @PostMapping("/register")
  public Map<String, Object> register(@RequestBody User user) {
    Map<String, Object> result = new HashMap<>();
    if (this.userService.register(user) != 0) {
      result.put("code", 20000);
      result.put("msg", "Register Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Register Error");
    }
    return result;
  }

  @GetMapping("/login")
  public Map<String, Object> login(@RequestBody Map<String, String> params) {
    Map<String, Object> result = new HashMap<>();
    String token = null;
    User user = this.userService.login(params.get("account"), params.get("password"));
    if (user != null) {
      token = TokenUtil.sign(user);
      result.put("code", 20000);
      result.put("msg", "Login Success");
      result.put("data", user);
      result.put("token", token);
    } else {
      result.put("code", 50000);
      result.put("msg", "Login Error,Please check your account and password");
    }
    return result;
  }

  @PostMapping("/updateuserpurview")
  public Map<String, Object> updatePurview(int purview, int uid) {
    Map<String, Object> result = new HashMap<>();
    if (this.userService.updateUserPurview(purview, uid) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }
}
