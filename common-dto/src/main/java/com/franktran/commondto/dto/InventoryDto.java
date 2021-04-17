package com.franktran.commondto.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class InventoryDto {

  private UUID orderId;
  private Integer productId;

}
