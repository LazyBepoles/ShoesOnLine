package com.ppwq.controller;

import com.ppwq.pojo.Poster;
import com.ppwq.service.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PosterController {
  @Autowired private PosterService posterService;

  @PostMapping("/insertad")
  public Map<String, Object> insertad(
      @RequestPart("req") Poster poster, @RequestPart("file") MultipartFile fileUpload) {
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
      poster.setAdpicname(fileName);
      if (this.posterService.insertad(poster, fileName) != 0) {
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
    System.out.println(poster);
    return result;
  }

  @DeleteMapping("/deletead/{adid}")
  public Map<String, Object> deletead(@PathVariable("adid") int adid) {
    Map<String, Object> result = new HashMap<>();
    if (this.posterService.deletead(adid) != 0) {
      result.put("code", 50000);
      result.put("msg", "删除成功");
    } else {
      result.put("code", 20000);
      result.put("msg", "删除失败");
    }
    return result;
  }

  @GetMapping("/getAllad")
  public Map<String, Object> getAllad() {
    Map<String, Object> result = new HashMap<>();
    result.put("data", this.posterService.getAllad());
    return result;
  }
}
