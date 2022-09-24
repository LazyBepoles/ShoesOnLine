package com.ppwq.service.impl;

import com.github.pagehelper.Page;
import com.ppwq.dao.BrandDao;
import com.ppwq.dao.CommodityDao;
import com.ppwq.pojo.Brand;
import com.ppwq.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public int addNewBrand(Brand brand) {
        return this.brandDao.addNewBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return this.brandDao.updateBrand(brand);
    }

    @Override
    public Brand searchBrandByName(String name) {
        return this.brandDao.searchBrandByName(name);
    }

    @Override
    public Brand searchBrandById(int id) {
        return this.brandDao.searchBrandById(id);
    }

    @Override
    public Page<Brand> searchBrandByPage() {
        return this.brandDao.searchBrandByPage();
    }

    @Override
    public int updateBrandStatus(int status,int bid) {
        return this.brandDao.updateBrandStatus(status,bid);
    }

    @Override
    public List<Brand> searchAllBrand() {
        List<Brand> brands = this.brandDao.searchAllBrand();
        for (Brand brand : brands ){
            brand.setCommodities(this.commodityDao.searchByBrand(brand.getBid()));
        }
        return brands;
    }
}
