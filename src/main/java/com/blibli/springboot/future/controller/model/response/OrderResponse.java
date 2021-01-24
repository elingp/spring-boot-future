package com.blibli.springboot.future.controller.model.response;

import com.blibli.springboot.future.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
  private int totalOrders;
  private List<Order> orders;
}
