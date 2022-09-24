package com.ppwq.controller;

import com.ppwq.pojo.Size;
import com.ppwq.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SizeController {

    @Autowired
    private SizeService service;

    @PostMapping("/addsize")
    public Map<String, Object> addSize(@RequestBody Size size) {
        Map<String, Object> result = new HashMap<>();
        if (this.service.addNewSize(size) != 0) {
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
        if (this.service.deleteSize(sid) != 0) {
            result.put("code", 20000);
            result.put("msg", "Delete Success");
        } else {
            result.put("code", 50000);
            result.put("msg", "Delete Error");
        }
        return result;
    }
}
