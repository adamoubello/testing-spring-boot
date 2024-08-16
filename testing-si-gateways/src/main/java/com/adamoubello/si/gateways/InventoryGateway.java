package com.adamoubello.si.gateways;

import com.adamoubello.si.model.commands.PlaceOrderCommand;
import org.springframework.integration.annotation.Gateway;
import org.springframework.validation.Errors;

import java.util.concurrent.Future;

public interface InventoryGateway {
    @Gateway(requestChannel = "verifyOrderInventoryChannel")
    Future<Errors> verifyOrderInventory(PlaceOrderCommand command);
}
