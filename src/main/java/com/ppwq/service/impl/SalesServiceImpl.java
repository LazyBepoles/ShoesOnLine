package com.ppwq.service.impl;

import com.github.pagehelper.Page;
import com.ppwq.dao.SalesDao;
import com.ppwq.pojo.Sales;
import com.ppwq.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesDao salesDao;

    @Override
    public Page<Sales> hotBrand() {
        return this.salesDao.hotBrand();
    }

    @Override
    public Page<Sales> hotType() {
        return this.salesDao.hotType();
    }

    @Override
    public Page<Sales> hotSize() {
        return this.salesDao.hotSize();
    }

    @Override
    public Page<Sales> hotCommodity() {
        return this.salesDao.hotCommodity();
    }

    @Override
    public Page<Sales> hotColor() {
        return this.salesDao.hotColor();
    }
}
