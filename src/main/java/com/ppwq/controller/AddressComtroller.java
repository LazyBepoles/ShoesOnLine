package com.ppwq.controller;

import com.ppwq.pojo.Address;
import com.ppwq.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AddressComtroller {

  @Autowired private AddressService addressService;

  @PostMapping("/addaddress")
  public Map<String, Object> addAddress(@RequestBody Address address) {
    Map<String, Object> result = new HashMap<>();
    if (this.addressService.addNewAddress(address) != 0) {
      result.put("code", 20000);
      result.put("msg", "Insert Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Insert Error");
    }
    return result;
  }

  @PostMapping("/updateaddress")
  public Map<String, Object> updateAddress(@RequestBody Address address) {
    Map<String, Object> result = new HashMap<>();
    if (this.addressService.addNewAddress(address) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @PostMapping("/delete/{aid}")
  public Map<String, Object> deleteAddress(@PathVariable int aid) {
    Map<String, Object> result = new HashMap<>();
    if (this.addressService.deleteAddress(aid) != 0) {
      result.put("code", 20000);
      result.put("msg", "Delete Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Delete Error");
    }
    return result;
  }

  @GetMapping("/getaddress/{uid}")
  public Map<String, Object> getAddress(@PathVariable int uid) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.addressService.getAllAddress(uid));
    return result;
  }

  @GetMapping("/getdetail/{aid}")
  public Map<String, Object> getDetail(@PathVariable int aid) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.addressService.getDetailAddress(aid));
    return result;
  }
}
