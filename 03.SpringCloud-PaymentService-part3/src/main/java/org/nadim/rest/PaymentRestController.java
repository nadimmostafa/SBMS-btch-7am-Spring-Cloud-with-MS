package org.nadim.rest;

import org.nadim.consumer.CartConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
	
	@Autowired
	private CartConsumer cart;
	@GetMapping("/info")
	public ResponseEntity<String> doPayment(){
		return ResponseEntity.ok(("Payment Done with "+cart.getCartServiceInstance()));
	}
}
