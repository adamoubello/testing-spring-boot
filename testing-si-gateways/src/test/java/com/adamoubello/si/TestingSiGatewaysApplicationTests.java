package com.adamoubello.si;

import com.adamoubello.si.gateways.ProductGateway;
import com.adamoubello.si.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestingSiGatewaysApplication.class)
public class TestingSiGatewaysApplicationTests {

	@Autowired
	ProductGateway productGateway;

	@Test
	public void contextLoads() {

		Product product = productGateway.getProduct("1234");

		System.out.println(product.getProductId());
		System.out.println(product.getDescription());
	}

}
