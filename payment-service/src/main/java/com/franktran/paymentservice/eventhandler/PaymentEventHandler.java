package com.franktran.paymentservice.eventhandler;

import com.franktran.commondto.event.order.OrderEvent;
import com.franktran.commondto.event.order.OrderStatus;
import com.franktran.commondto.event.payment.PaymentEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class PaymentEventHandler {

  @Bean
  public Function<Flux<OrderEvent>, Flux<PaymentEvent>> paymentProcessor() {
    return flux -> flux.flatMap()
  }

  private Mono<PaymentEvent> processPayment(OrderEvent orderEvent) {
    if (OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus())) {
      return Mono.fromSupplier(() -> )
    }
  }
}
