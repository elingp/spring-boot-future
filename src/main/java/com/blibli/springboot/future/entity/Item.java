package com.blibli.springboot.future.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
  private int price;
  private int quantity;
  private String name;
  private int id;
}
