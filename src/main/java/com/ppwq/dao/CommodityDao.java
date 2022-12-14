package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CommodityDao {

  Page<Commodity> searchCommodityByPage();

  int addNewCommodity(@Param("params") Map<String, Object> params);

  int updateCommodity(Commodity commodity);

  int updateCommodityStatus(@Param("status") int status, @Param("cid") int cid);

  Commodity searchDetail(int cid);

  Page<Commodity> searchByBrand(int bid);

  Page<Commodity> fuzzyQuery(@Param("params") Map<String, Object> params);

  int addCommodityImages(@Param("images") List<String> images, @Param("cid") int cid);

  List<String> searchImages(int cid);

  int deleteImage(@Param("cid") int cid, @Param("image") String image);

  int updateImage(@Param("images") List<String> images, @Param("cid") int cid);

  int updateStock(@Param("params") Map<String, Object> params);
}
