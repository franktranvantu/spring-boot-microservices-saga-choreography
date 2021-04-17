package com.franktran.commondto.event;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class Event {

  private final UUID orderId = UUID.randomUUID();
  private final LocalDateTime date = LocalDateTime.now();

}
