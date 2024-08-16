package com.adamoubello.si.gateways;

import com.adamoubello.si.model.Product;
import org.springframework.integration.annotation.Gateway;

public interface ProductGateway {

    @Gateway(requestChannel = "getProductChannel")
    Product getProduct(String productId);
}
