package com.adamoubello.si.services;

import com.adamoubello.si.model.commands.PlaceOrderCommand;
import org.springframework.validation.Errors;

public interface InventoryService {
    Errors verifyInventory(PlaceOrderCommand command);
}
