package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Order;
import com.ppwq.pojo.OrderShoes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface OrderDao {

    int addNewOrder(Order order);

    int addNewOrderShoes(OrderShoes orderShoes);

    int updateOrderStatus(@Param("params")Map<String,Object> params);

    Page<Order> searchOrder(@Param("uid") int uid,@Param("status") int status);


}
