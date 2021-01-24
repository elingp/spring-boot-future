package com.blibli.springboot.future.controller;

import com.blibli.springboot.future.controller.model.request.CreateOrderRequest;
import com.blibli.springboot.future.entity.Order;
import com.blibli.springboot.future.service.impl.CashierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CashierController {

  @Autowired private CashierServiceImpl cashierService;

  @GetMapping(value = "/orders")
  public List<Order> getAllOrder(
      @RequestParam(defaultValue = "false", required = false) boolean orderByCustomer,
      @RequestParam(defaultValue = "false", required = false) boolean orderByPrice) {
    return cashierService.getAllOrder(orderByCustomer, orderByPrice);
  }

  @GetMapping(value = "/orders/{id}")
  public Order getOrder(@PathVariable int id) {
    return cashierService.getOrderById(id);
  }

  @PostMapping(value = "/orders")
  public String createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
    cashierService.createOrder(createOrderRequest);
    return "success";
  }
}
