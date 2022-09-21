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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
        this.carDao.deleteCar((Integer) params.get("carid"));
      }
    }
    return result;
  }

  @Override
  public Page<Order> searchOrder(int uid,int status) {
    return this.orderDao.searchOrder(uid,status);
  }

  @Override
  public int updateOrderStatus(Map<String, Object> params) {
    params.put("sendTime",new Date());
    return this.orderDao.updateOrderStatus(params);
  }
}
