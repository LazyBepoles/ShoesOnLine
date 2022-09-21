package com.ppwq.service.impl;

import com.github.pagehelper.Page;
import com.ppwq.dao.BrandDao;
import com.ppwq.dao.CommodityDao;
import com.ppwq.dao.SizeDao;
import com.ppwq.dao.TypeDao;
import com.ppwq.pojo.Brand;
import com.ppwq.pojo.Commodity;
import com.ppwq.pojo.Type;
import com.ppwq.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {

  @Autowired private CommodityDao commodityDao;
  @Autowired private SizeDao sizeDao;
  @Autowired private BrandDao brandDao;
  @Autowired private TypeDao typeDao;

  @Transactional
  @Override
  public int addNewCommodity(Map<String, Object> params) {
    params.put("createTime", new Date());
    int result = this.commodityDao.addNewCommodity(params);
    Map<String, Object> map = (Map<String, Object>) params.get("size");
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      this.sizeDao.addNewCommodity(entry.getKey(), (Integer) params.get("cid"), entry.getValue());
    }
    this.commodityDao.addCommodityImages((List<String>) params.get("images"),(Integer) params.get("cid"));
    return result;
  }

  @Override
  public Page<Commodity> searchAllCommodityByPage() {
    return this.commodityDao.searchCommodityByPage();
  }

  @Override
  public int updateCommodity(Commodity commodity) {
    return this.commodityDao.updateCommodity(commodity);
  }

  @Override
  public int updateCommodityStatus(int status) {
    return this.commodityDao.updateCommodityStatus(status);
  }

  @Override
  public Commodity searchDetail(int cid) {
    return this.commodityDao.searchDetail(cid);
  }

  @Override
  @Transactional
  public Page<Commodity> fuzzyQuery(String bname, String tname, String sexname, String color, int sid) {
    Brand brand = new Brand();
    Type type = new Type();
    if (bname == "" || bname == null){
      brand.setBid(0);
    }else {
      brand = this.brandDao.searchBrandByName(bname);
    }
    if (tname == "" || tname == null){
      type.setTid(0);
    }else {
      type = this.typeDao.searchTypeByName(tname);
    }
    int sex = -1;
    if (sexname.contains("男"))sex = 1;
    else if (sexname.contains("女"))sex = 0;
    return this.commodityDao.fuzzyQuery(brand.getBid(),type.getTid(),sex,color,sex);
  }

  @Override
  public int updateImage(List<String> images, int cid) {
    return this.commodityDao.addCommodityImages(images,cid);
  }

  @Override
  public int deleteImage(int cid, String image) {
    return this.commodityDao.deleteImage(cid,image);
  }
}
