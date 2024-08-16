package com.adamoubello.si.gateway

import com.adamoubello.si.gateways.OrderGateway
import com.adamoubello.si.model.commands.PlaceOrderCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(locations = "classpath*:/spring/si-config.xml")
class OrderGatewayTests extends Specification {

    @Autowired
    OrderGateway orderGateway

    def "Test Place Order"() {
        given:
        PlaceOrderCommand command = new PlaceOrderCommand()

        when:
        PlaceOrderCommand result = orderGateway.placeOrder(command)

        then:
        result
    }
}
