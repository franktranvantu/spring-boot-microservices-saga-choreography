package com.franktran.commondto.event.inventory;

import com.franktran.commondto.dto.InventoryDto;
import com.franktran.commondto.event.Event;
import lombok.Data;

@Data
public class InventoryEvent extends Event {

  private InventoryDto inventory;

}
