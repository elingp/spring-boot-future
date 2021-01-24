package com.blibli.springboot.future.controller.model.request;

import com.blibli.springboot.future.entity.Customer;
import com.blibli.springboot.future.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
  private List<Item> orderItems = new ArrayList<>();
  private int totalPrice;
  private Customer customer;
}
