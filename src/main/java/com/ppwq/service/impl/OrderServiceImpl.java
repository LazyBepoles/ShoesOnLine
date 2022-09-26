package com.ppwq.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.ppwq.dao.CarDao;
import com.ppwq.dao.OrderDao;
import com.ppwq.dao.SizeDao;
import com.ppwq.pojo.Order;
import com.ppwq.pojo.OrderShoes;
import com.ppwq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired private OrderDao orderDao;
  @Autowired private SizeDao sizeDao;
  @Autowired private CarDao carDao;

  @Override
  @Transactional
  public int addNewOrder(Map<String, Object> params) {
    Order order = JSON.parseObject(JSON.toJSONString(params.get("order")), Order.class);
    order.setCreateTime(new Date());
    String num =
        String.valueOf(System.currentTimeMillis())
            + String.valueOf(new Random().nextInt(100))
            + order.getUid();
    order.setOrdernum(num);
    int result = this.orderDao.addNewOrder(order);
    List<OrderShoes> orderShoes =
        JSONArray.parseArray(JSONArray.toJSONString(params.get("commodities")), OrderShoes.class);
    for (OrderShoes shoes : orderShoes) {
      shoes.setOid(order.getOid());
      int stock = this.sizeDao.selectSize(shoes.getSid(), shoes.getCid());
      if (stock >= shoes.getNumber()) {
        this.orderDao.addNewOrderShoes(shoes);
        stock = stock - shoes.getNumber();
        this.sizeDao.updateSizeNum(shoes.getSid(), shoes.getCid(), stock);
      } else return 0;
      if (params.get("carid") != null) {
        Map<String,Object> pmap = new HashMap<>();
        pmap.put("uid",order.getUid());
        pmap.put("cid",shoes.getCid());
        pmap.put("sid",shoes.getSid());
        this.carDao.deleteOrderCar(pmap);
      }
    }
    return result;
  }

  @Override
  public Page<Order> searchOrder(Map<String, Object> params) {
    return this.orderDao.searchOrder(params);
  }

  @Override
  public int updateOrderStatus(Map<String, Object> params) {
    if (params.get("paymethod") != null) {
      params.put("paymentTime", new Date());
      params.put("status", 20);
    } else if (params.get("send") != null) {
      params.put("sendTime", new Date());
      params.put("status", 30);
    } else if (params.get("complete") != null) {
      params.put("endTime", new Date());
      params.put("status", 40);
    } else if (params.get("cancle") != null) {
      params.put("endTime", new Date());
      params.put("status", 0);
      List<OrderShoes> orderShoes =
          JSONArray.parseArray(JSONArray.toJSONString(params.get("commodities")), OrderShoes.class);
      for (OrderShoes shoes : orderShoes) {
        int stock = this.sizeDao.selectSize(shoes.getSid(), shoes.getCid());
        stock = stock + shoes.getNumber();
        this.sizeDao.updateSizeNum(shoes.getSid(), shoes.getCid(), stock);
      }
    } else if (params.get("refund") != null) {
      params.put("status", 50);
    }
    return this.orderDao.updateOrderStatus(params);
  }

  @Override
  public Order getDetail(int oid) {
    return this.orderDao.getDetail(oid);
  }

  @Override
  public Page<Order> noSendOrder() {
    return this.orderDao.noSendOrder();
  }

  @Override
  public Page<Order> refund() {
    return this.orderDao.refund();
  }
}
