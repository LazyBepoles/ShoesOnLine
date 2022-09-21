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
public class Commodity {

  private Integer cid;
  private String name;
  private String color;
  private BigDecimal price;
  private Double discount;
  private Integer sex;
  private Integer status;
  private Date createTime;

  private String tname;
  private String bname;
  private List<ShoesSize> shoesSizes;
  private List<String> images;
}
