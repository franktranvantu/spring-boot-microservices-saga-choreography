package com.franktran.orderservice;

import com.franktran.commondto.dto.OrderStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class PurchaseOrder {

  @Id
  private UUID id;
  private Integer userId;
  private Integer productId;
  private Integer price;
  private OrderStatus status;

}
