package com.blibli.springboot.future.entity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Order {
  private List<Item> orderItems = new ArrayList<>();
  private int totalPrice;
  private Customer customer;
  private int id;
}
