package com.blibli.springboot.future.controller;

import com.blibli.springboot.future.controller.model.request.CreateOrderRequest;
import com.blibli.springboot.future.controller.model.response.OrderResponse;
import com.blibli.springboot.future.service.impl.CashierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CashierController {

  @Autowired private CashierServiceImpl cashierService;

  @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
  public OrderResponse getOrder(
      @RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
    switch (orderBy) {
      case "customer":
        return cashierService.getAllOrder(1);
      case "price":
        return cashierService.getAllOrder(2);
      default:
        return cashierService.getAllOrder(0);
    }
  }

  @PostMapping(value = "/orders")
  public String createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
    cashierService.createOrder(createOrderRequest);
    return "success";
  }
}
