package com.blibli.springboot.future.service.impl;

import com.blibli.springboot.future.controller.model.request.CreateOrderRequest;
import com.blibli.springboot.future.entity.Order;
import com.blibli.springboot.future.service.CashierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    private List<Order> orders = new ArrayList<>();
    private int orderId = 0;

  @Override
  public List<Order> getOrder() {
    return orders;
  }

  @Override
  public Order createOrder(CreateOrderRequest createOrderRequest) {
      Order order = Order
              .builder()
              .orderItems(createOrderRequest.getOrderItems())
              .totalPrice(createOrderRequest.getTotalPrice())
              .customer(createOrderRequest.getCustomer())
              .id(++orderId)
              .build();
      orders.add(order);
    return order;
  }
}
