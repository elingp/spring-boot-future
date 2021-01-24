package com.blibli.springboot.future.service;

import com.blibli.springboot.future.controller.model.request.CreateOrderRequest;
import com.blibli.springboot.future.controller.model.response.OrderResponse;
import com.blibli.springboot.future.entity.Order;

public interface CashierService {

  OrderResponse getOrder();

  Order createOrder(CreateOrderRequest createOrderRequest);
}
