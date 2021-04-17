package com.franktran.orderservice;

import com.franktran.commondto.event.order.OrderEvent;
import com.google.common.collect.ImmutableMap;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Sinks;

import java.util.Collections;
import java.util.Map;

@Configuration
public class OrderConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public Sinks.Many<OrderEvent> orderEvent() {
    return Sinks.many().unicast().onBackpressureBuffer();
  }

  @Bean
  public Map<Integer, Integer> productPrice() {
    return ImmutableMap.of(
        1, 100,
        2, 200,
        3, 300
    );
  }
}
