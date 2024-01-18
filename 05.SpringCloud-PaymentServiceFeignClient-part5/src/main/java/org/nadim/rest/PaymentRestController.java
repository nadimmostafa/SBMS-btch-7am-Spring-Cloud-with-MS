package org.nadim.rest;

import org.nadim.consumer.CartConsumer;
import org.nadim.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
	
	@Autowired
	private CartConsumer cart;
	
	@GetMapping("info")
	public ResponseEntity<String> doPayment(){
		return ResponseEntity.ok("Payment with "+ cart.getCartItem().getBody());
	}
	
	@PostMapping("/new")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart2){
		String response = cart.create(cart2).getBody();
		return ResponseEntity.ok("Pay with "+ response);
	}
}
