package com.blibli.springboot.future.service.impl;

import com.blibli.springboot.future.controller.model.request.CreateOrderRequest;
import com.blibli.springboot.future.entity.Customer;
import com.blibli.springboot.future.entity.Item;
import com.blibli.springboot.future.entity.Order;
import com.blibli.springboot.future.service.CashierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class CashierServiceImpl implements CashierService {

  private final List<Order> orders = new ArrayList<>();
  private int orderId = 1;

  @Override
  public List<Order> getAllOrder(boolean orderByCustomer, boolean orderByPrice) {
    if (orderByCustomer) {
      orders.sort(Comparator.comparing(order -> order.getCustomer().getName()));
    } else if (orderByPrice) {
      orders.sort(Comparator.comparing(Order::getTotalPrice).reversed());
    }
    return orders;
  }

  @Override
  public Order getOrderById(int id) {
    return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
  }

  @Override
  public void createOrder(CreateOrderRequest createOrderRequest) {
    AtomicInteger itemId = new AtomicInteger(1);
    orders.add(
        Order.builder()
            .id(orderId++)
            .customer(
                Customer.builder()
                    .name(createOrderRequest.getCustomer().getName())
                    .email(createOrderRequest.getCustomer().getEmail())
                    .build())
            .orderItems(
                createOrderRequest.getOrderItems().stream()
                    .map(
                        item ->
                            Item.builder()
                                .price(item.getPrice())
                                .quantity(item.getQuantity())
                                .name(item.getName())
                                .id(itemId.getAndIncrement())
                                .build())
                    .collect(Collectors.toList()))
            .totalPrice(
                (int)
                    createOrderRequest.getOrderItems().stream()
                        .mapToDouble(item -> item.getPrice() * item.getQuantity())
                        .sum())
            .build());
  }
}
