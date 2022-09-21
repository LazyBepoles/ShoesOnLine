package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.pojo.Brand;
import com.ppwq.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BrandController {

  @Autowired private BrandService brandService;

  @PostMapping("/addbrand")
  public Map<String, Object> addBrand(@RequestBody Brand brand) {
    Map<String, Object> result = new HashMap<>();
    if (this.brandService.addNewBrand(brand) != 0) {
      result.put("code", 20000);
      result.put("msg", "Insert Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Insert Error");
    }
    return result;
  }

  @PostMapping("/updatebrand")
  public Map<String, Object> updateBrand(@RequestBody Brand brand) {
    Map<String, Object> result = new HashMap<>();
    if (this.brandService.updateBrand(brand) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @GetMapping("/searchbrand")
  public Map<String, Object> searchBrandByName(@RequestBody Map<String,Object> params) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.brandService.searchBrandByName((String) params.get("name")));
    return result;
  }

  @GetMapping("/searchbrand/{id}")
  public Map<String, Object> searchBrandById(@PathVariable int id) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.brandService.searchBrandById(id));
    return result;
  }

  @GetMapping("/getbrand")
  public Map<String, Object> searchBrandByPage(@RequestBody Map<String,Integer> params) {
    PageHelper.startPage(params.get("pageNum"),params.get("pageSize"));
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.brandService.searchBrandByPage());
    return result;
  }

  @PostMapping("/updatebrandstatus")
  public Map<String, Object> updateStatus(int status){
    Map<String, Object> result = new HashMap<>();
    if (this.brandService.updateBrandStatus(status)!=0){
      result.put("code", 20000);
      result.put("msg", "Update Success");
    }else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @GetMapping("/getallbrand")
  public Map<String, Object> searchTypeByPage() {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Result");
    result.put("data", this.brandService.searchAllBrand());
    return result;
  }
}
