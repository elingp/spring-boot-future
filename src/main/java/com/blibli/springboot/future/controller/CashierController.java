package com.blibli.springboot.future.controller;

import com.blibli.springboot.future.controller.model.request.CreateOrderRequest;
import com.blibli.springboot.future.entity.Order;
import com.blibli.springboot.future.service.impl.CashierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CashierController {

    @Autowired
    private CashierServiceImpl cashierService;


    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrder() {
        return cashierService.getOrder();
    }

    @PostMapping(value = "/orders")
    public String createOrder(
            @RequestBody CreateOrderRequest createOrderRequest
    ) {
        cashierService.createOrder(createOrderRequest);
        return "success";
    }
}
