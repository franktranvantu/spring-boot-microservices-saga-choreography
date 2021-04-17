package com.franktran.orderservice;

import com.franktran.commondto.dto.OrderRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderResource {

  private final OrderCommandService orderCommandService;

  public OrderResource(OrderCommandService orderCommandService) {
    this.orderCommandService = orderCommandService;
  }

  @PostMapping
  public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequest) {
    orderRequest.setOrderId(UUID.randomUUID());
    return orderCommandService.createOrder(orderRequest);
  }
}
