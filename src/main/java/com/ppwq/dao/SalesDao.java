package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SalesDao {

    Page<Sales> hotBrand();

    Page<Sales> hotType();

    Page<Sales> hotSize();

    Page<Sales> hotCommodity();

    Page<Sales> hotColor();
}
