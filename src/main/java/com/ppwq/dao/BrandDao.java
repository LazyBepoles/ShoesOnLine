package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BrandDao {

  int addNewBrand(Brand brand);

  int updateBrand(Brand brand);

  Brand searchBrandByName(String name);

  Brand searchBrandById(int id);

  Page<Brand> searchBrandByPage();

  int updateBrandStatus(int status);

  List<Brand> searchAllBrand();
}
