package org.nadim.consumer;

import org.nadim.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CART-API")
public interface CartConsumer {
	
	@GetMapping("/cart/item")
	public ResponseEntity<String> getCartItem();
	
	@PostMapping("/cart/create")
	public ResponseEntity<String> create(@RequestBody Cart cart);
}
