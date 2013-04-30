package com.examples.ws.jaxb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.examples.ws.jaxb.service.OrderService;
import com.springws.jaxb.domain.CancelOrderRequest;
import com.springws.jaxb.domain.CancelOrderResponse;
import com.springws.jaxb.domain.ObjectFactory;
import com.springws.jaxb.domain.PlaceOrderRequest;
import com.springws.jaxb.domain.PlaceOrderResponse;

@Endpoint
public class OrderServiceEndpoint {

	private final OrderService orderService;
	private final ObjectFactory JAXB_OBJECT_FACTORY = new ObjectFactory();
	private final String SERVICE_NS = "http://www.packtpub.com/liverestaurant/OrderService/schema";

	@Autowired
	public OrderServiceEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}

	@PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
	public PlaceOrderResponse getOrder(
			PlaceOrderRequest placeOrderRequest) {
		
		PlaceOrderResponse response = JAXB_OBJECT_FACTORY
				.createPlaceOrderResponse();
		response.setRefNumber(orderService.placeOrder(placeOrderRequest
				.getOrder()));

		return response;
	}

	@PayloadRoot(localPart = "cancelOrderRequest", namespace = SERVICE_NS)
	public CancelOrderResponse cancelOrder(
			CancelOrderRequest cancelOrderRequest) {
		
		CancelOrderResponse response = JAXB_OBJECT_FACTORY
				.createCancelOrderResponse();
		response.setCancelled(orderService.cancelOrder(cancelOrderRequest
				.getRefNumber()));
		return response;
	}

}