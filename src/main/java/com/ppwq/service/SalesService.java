package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Sales;

public interface SalesService {

    Page<Sales> hotBrand();

    Page<Sales> hotType();

    Page<Sales> hotSize();

    Page<Sales> hotCommodity();

    Page<Sales> hotColor();
}
