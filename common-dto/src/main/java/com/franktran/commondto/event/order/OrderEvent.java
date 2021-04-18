package com.franktran.commondto.event.order;

import com.franktran.commondto.dto.OrderDto;
import com.franktran.commondto.event.Event;
import lombok.Data;

@Data
public class OrderEvent extends Event {

  private OrderDto order;
  private OrderStatus orderStatus;

}
