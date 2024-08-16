package com.adamoubello.si.gateways;

import com.adamoubello.si.model.commands.PlaceOrderCommand;
import org.springframework.integration.annotation.Gateway;
import org.springframework.validation.Errors;

import java.util.concurrent.Future;

public interface OrderGateway {

    @Gateway(requestChannel = "placeOrderChannel")
    PlaceOrderCommand placeOrder(PlaceOrderCommand command);

    @Gateway(requestChannel = "validateOrderChannel")
    Future<Errors> validateOrder(PlaceOrderCommand command);
}
