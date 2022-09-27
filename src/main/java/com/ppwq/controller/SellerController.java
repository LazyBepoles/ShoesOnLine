package com.ppwq.controller;

import com.ppwq.pojo.Seller;
import com.ppwq.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SellerController {

  @Autowired private SellerService sellerService;

  @PostMapping("/insertseller")
  public Map<String, Object> insert(
      @RequestPart("req") Seller seller, @RequestPart("file") MultipartFile fileUpload) {
    // 获取文件名
    String fileName = fileUpload.getOriginalFilename();
    // 获取文件后缀名
    String suffixName = fileName.substring(fileName.lastIndexOf("."));
    // 重新生成文件名
    // 指定本地文件夹存储图片，写到需要保存的目录下
    String filePath = "E:\\Projects\\ShoesOnLine\\src\\main\\resources\\static\\images\\";
    Map<String, Object> result = new HashMap<>();
    try {
      // 将图片保存到static文件夹里
      fileUpload.transferTo(new File(filePath + fileName));
      // 返回提示信息
      seller.setSellerpicname(fileName);
      if (this.sellerService.insert(seller, fileName) != 0) {
        result.put("code", 50000);
        result.put("msg", "添加成功");
      } else {
        result.put("code", 20000);
        result.put("msg", "添加失败");
      }
    } catch (Exception e) {
      e.printStackTrace();
      result.put("code", 20000);
      result.put("msg", "添加失败");
    }
    System.out.println(seller);
    return result;
  }

  @DeleteMapping("/deleteseller/{sellerid}")
  public Map<String, Object> delete(@PathVariable("sellerid") int sellerid) {
    Map<String, Object> result = new HashMap<>();
    if (this.sellerService.delete(sellerid) != 0) {
      result.put("code", 50000);
      result.put("msg", "删除成功");
    } else {
      result.put("code", 20000);
      result.put("msg", "删除失败");
    }
    return result;
  }

  @GetMapping("/getAllSeller")
  public Map<String, Object> getAll() {
    Map<String, Object> result = new HashMap<>();
    result.put("data", this.sellerService.getAll());
    return result;
  }
}
