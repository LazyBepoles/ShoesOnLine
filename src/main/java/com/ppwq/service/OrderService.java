package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Order;

import java.util.Map;

public interface OrderService {

    int addNewOrder(Map<String, Object> params);

    Page<Order> searchOrder(int uid,int status);

    int updateOrderStatus(Map<String,Object> params);
}
