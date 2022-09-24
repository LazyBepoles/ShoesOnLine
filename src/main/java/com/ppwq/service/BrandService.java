package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Brand;

import java.util.List;

public interface BrandService {

  int addNewBrand(Brand brand);

  int updateBrand(Brand brand);

  Brand searchBrandByName(String name);

  Brand searchBrandById(int id);

  Page<Brand> searchBrandByPage();

  int updateBrandStatus(int status,int bid);

  List<Brand> searchAllBrand();
}
