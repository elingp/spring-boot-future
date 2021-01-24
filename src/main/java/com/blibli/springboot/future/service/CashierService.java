package com.blibli.springboot.future.service;

import com.blibli.springboot.future.controller.model.request.CreateOrderRequest;
import com.blibli.springboot.future.entity.Order;

import java.util.List;

public interface CashierService {

  List<Order> getAllOrder(boolean orderByCustomer, boolean orderByPrice);

  Order getOrderById(int id);

  void createOrder(CreateOrderRequest createOrderRequest);
}
