package com.franktran.paymentservice.config;

import com.franktran.commondto.event.order.OrderEvent;
import com.franktran.commondto.event.order.OrderStatus;
import com.franktran.commondto.event.payment.PaymentEvent;
import com.franktran.paymentservice.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class PaymentConfig {

  private final PaymentService paymentService;

  public PaymentConfig(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @Bean
  public Function<Flux<OrderEvent>, Flux<PaymentEvent>> paymentProcessor() {
    return flux -> flux.flatMap(this::processPayment);
  }

  private Mono<PaymentEvent> processPayment(OrderEvent orderEvent) {
    if (orderEvent.getOrderStatus().equals(OrderStatus.ORDER_CREATED)) {
      return Mono.fromSupplier(() -> paymentService.newOrderEvent(orderEvent));
    }
    return Mono.fromRunnable(() -> paymentService.cancelOrderEvent(orderEvent));
  }
}
