package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Order;

import java.util.Map;

public interface OrderService {

    int addNewOrder(Map<String, Object> params);

    Page<Order> searchOrder(Map<String, Object> params);

    int updateOrderStatus(Map<String,Object> params);

    Order getDetail(int oid);

    Page<Order> noSendOrder();

    Page<Order> refund();
}
