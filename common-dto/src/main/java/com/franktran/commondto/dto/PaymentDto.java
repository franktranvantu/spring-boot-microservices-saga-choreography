package com.franktran.commondto.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PaymentDto {

  private UUID orderId;
  private Integer userId;
  private Integer amount;

}
