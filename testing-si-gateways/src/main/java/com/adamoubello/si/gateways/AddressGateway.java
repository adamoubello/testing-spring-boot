package com.adamoubello.si.gateways;

import com.adamoubello.si.model.commands.PlaceOrderCommand;
import org.springframework.integration.annotation.Gateway;
import org.springframework.validation.Errors;

import java.util.concurrent.Future;

public interface AddressGateway {

    @Gateway(requestChannel = "verifyAddressChannel")
    Future<Errors> verifyAddress(PlaceOrderCommand command);
}
