package com.blibli.springboot.future.controller.model.response;

import com.blibli.springboot.future.entity.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
  private Order orders;
}
