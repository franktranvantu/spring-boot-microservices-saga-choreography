package com.franktran.orderservice;

import com.franktran.commondto.dto.OrderDto;
import com.franktran.commondto.event.order.OrderEvent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderPublisher {

  private final Sinks.Many<OrderEvent> orderSink;
  private final ModelMapper modelMapper;

  public OrderPublisher(Sinks.Many<OrderEvent> orderSink, ModelMapper modelMapper) {
    this.orderSink = orderSink;
    this.modelMapper = modelMapper;
  }

  public void raiseOrderEvent(PurchaseOrder purchaseOrder) {
    OrderDto orderDto = modelMapper.map(purchaseOrder, OrderDto.class);
    OrderEvent orderEvent = new OrderEvent(orderDto);
    orderSink.tryEmitNext(orderEvent);
  }
}
