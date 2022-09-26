package com.ppwq.controller;

import com.github.pagehelper.PageHelper;
import com.ppwq.pojo.Commodity;
import com.ppwq.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommodityController {

  @Autowired private CommodityService commodityService;

  @PostMapping("/addcommodity")
  public Map<String, Object> addCommodity(
      @RequestPart("params") Map<String, Object> params,
      @RequestPart("files") MultipartFile[] files) {
    List<String> images = new ArrayList<>();
    Map<String, Object> result = new HashMap<>();
    String path = "E:\\Projects\\ShoesOnLine\\src\\main\\resources\\static\\images\\";
    File realPath = new File(path);
    if (!realPath.exists()) {
      realPath.mkdir();
    }
    for (MultipartFile file : files) {
      String fileName = file.getOriginalFilename();
      images.add(fileName);
      try {
        file.transferTo(new File(path + fileName));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    params.put("images", images);
    if (this.commodityService.addNewCommodity(params) != 0) {
      result.put("code", 20000);
      result.put("msg", "Insert Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Insert Error");
    }
    return result;
  }

  @GetMapping("/getcommodity")
  public Map<String, Object> getCommodityByPage(@RequestBody Map<String, Object> params) {
    if (params.get("orderBy") != null) {
      PageHelper.startPage(
          (Integer) params.get("pageNum"),
          (Integer) params.get("pageSize"),
          (String) params.get("orderBy"));
    } else {
      PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
    }
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.commodityService.searchAllCommodityByPage());
    return result;
  }

  @PostMapping("/updatecommoditystatus")
  public Map<String, Object> updateStatus(int status,int cid) {
    Map<String, Object> result = new HashMap<>();
    if (this.commodityService.updateCommodityStatus(status,cid) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @PostMapping("/updatecommodity")
  public Map<String, Object> updateCommodity(@RequestBody Commodity commodity) {
    Map<String, Object> result = new HashMap<>();
    if (this.commodityService.updateCommodity(commodity) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @GetMapping("/getcommoditydetail/{id}")
  public Map<String, Object> getCommodityDetail(@PathVariable int id) {
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put("data", this.commodityService.searchDetail(id));
    return result;
  }

  @GetMapping("/fuzzyquery")
  public Map<String, Object> fuzzyQuery(@RequestBody Map<String, Object> params) {
    PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("msg", "Search Success");
    result.put(
        "data",
        this.commodityService.fuzzyQuery(params));
    return result;
  }

  @PostMapping("/updateimage")
  public Map<String, Object> updateImage(
      @RequestPart("files") MultipartFile[] files, @RequestPart("cid") int cid) {
    List<String> images = new ArrayList<>();
    Map<String, Object> result = new HashMap<>();
    String path = "E:\\Projects\\ShoesOnLine\\src\\main\\resources\\static\\images\\";
    File realPath = new File(path);
    if (!realPath.exists()) {
      realPath.mkdir();
    }
    for (MultipartFile file : files) {
      String fileName = file.getOriginalFilename();
      images.add(fileName);
      try {
        file.transferTo(new File(path + fileName));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (this.commodityService.updateImage(images,cid) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }

  @PostMapping("/deleteimage")
  public Map<String, Object> deleteImage(@RequestBody Map<String, Object> params) {
    Map<String, Object> result = new HashMap<>();
    String path = "E:\\Projects\\ShoesOnLine\\src\\main\\resources\\static\\images\\";
    if (this.commodityService.deleteImage((Integer) params.get("cid"), (String) params.get("image")) != 0) {
      new File(path+(String) params.get("image")).delete();
      result.put("code", 20000);
      result.put("msg", "Delete Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Delete Error");
    }
    return result;
  }

  @PostMapping("/updatestock")
  public Map<String, Object> updateStock(@RequestBody Map<String, Object> params) {
    Map<String, Object> result = new HashMap<>();
    if (this.commodityService.updateStock(params) != 0) {
      result.put("code", 20000);
      result.put("msg", "Update Success");
    } else {
      result.put("code", 50000);
      result.put("msg", "Update Error");
    }
    return result;
  }
}
