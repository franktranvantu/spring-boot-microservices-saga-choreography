package com.franktran.orderservice;

import com.franktran.commondto.dto.OrderRequestDto;
import com.franktran.commondto.dto.OrderStatus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class OrderCommandService {

  private final OrderRepository orderRepository;
  private final ModelMapper modelMapper;
  private final OrderPublisher orderPublisher;
  private final Map<Integer, Integer> productPrice;

  public OrderCommandService(OrderRepository orderRepository,
                             ModelMapper modelMapper,
                             OrderPublisher orderPublisher,
                             Map<Integer, Integer> productPrice) {
    this.orderRepository = orderRepository;
    this.modelMapper = modelMapper;
    this.orderPublisher = orderPublisher;
    this.productPrice = productPrice;
  }

  @Transactional
  public PurchaseOrder createOrder(OrderRequestDto orderRequest) {
    PurchaseOrder purchaseOrder = modelMapper.map(orderRequest, PurchaseOrder.class);
    purchaseOrder.setStatus(OrderStatus.ORDER_CREATED);
    purchaseOrder.setPrice(productPrice.get(orderRequest.getProductId()));
    orderRepository.save(purchaseOrder);
    orderPublisher.raiseOrderEvent(purchaseOrder);
    return purchaseOrder;
  }

}
