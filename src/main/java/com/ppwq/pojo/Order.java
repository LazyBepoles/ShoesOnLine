package com.ppwq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer oid;
    private String ordernum;
    private Integer uid;
    private Integer aid;
    private Date createTime;
    private Integer status;
    private Date paymentTime;
    private Date sendTime;
    private Date endTime;
    private BigDecimal postage;
    private BigDecimal price;
    private String paymethod;
    private String logistics;

    List<OrderShoes> orderShoes;
}
