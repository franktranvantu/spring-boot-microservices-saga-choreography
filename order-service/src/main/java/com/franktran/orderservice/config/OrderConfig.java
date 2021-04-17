package com.franktran.orderservice.config;

import com.franktran.commondto.event.order.OrderEvent;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Sinks;

@Configuration
public class OrderConfig {

  @Bean
  public Sinks.Many<OrderEvent> orderEvent() {
    return Sinks.many().unicast().onBackpressureBuffer();
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
