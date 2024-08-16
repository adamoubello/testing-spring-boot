package com.adamoubello.si.services;

import com.adamoubello.si.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProduct(String productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("Product from Production");

        return product;
    }
}
