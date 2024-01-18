package org.nadim.rest;

import org.nadim.entity.Cart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/item")
	public ResponseEntity<String> getCartItem(){
		return ResponseEntity.ok("Product Added into Cart "+port);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Cart cart){
		return ResponseEntity.ok("Add to cart "+ cart);
	}
}
