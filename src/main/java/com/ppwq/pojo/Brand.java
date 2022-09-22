package com.ppwq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

  private Integer bid;
  private String name;
  private Integer status;

  private List<Commodity> commodities;
}
