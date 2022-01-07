package com.learning.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.poc.Model.OrderDetails;
import com.learning.poc.repository.orderRepository;

@RestController
@RequestMapping("orderDetails")
public class OrderController {
	
	@Autowired 
	orderRepository orderRepo;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable Integer orderId)
	{
		OrderDetails orderdetails=new OrderDetails();
		RestTemplate restTemplate=new RestTemplate();
		orderdetails=restTemplate.getForObject("http://localhost:8002/orderDetails/"+orderId, OrderDetails.class);
		
		return ResponseEntity.ok().body(orderdetails);
	}

}
