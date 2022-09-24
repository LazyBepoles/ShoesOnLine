package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Commodity;

import java.util.List;
import java.util.Map;

public interface CommodityService {

  int addNewCommodity(Map<String, Object> params);

  Page<Commodity> searchAllCommodityByPage();

  int updateCommodity(Commodity commodity);

  int updateCommodityStatus(int status,int cid);

  Commodity searchDetail(int cid);

  Page<Commodity> fuzzyQuery(Map<String, Object> params);

  int updateImage(List<String> images, int cid);

  int deleteImage(int cid, String image);
}
