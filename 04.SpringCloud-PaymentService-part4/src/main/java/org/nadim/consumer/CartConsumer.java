package org.nadim.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumer {
	
	@Autowired
	private LoadBalancerClient client;
	
	public String getCartServiceInstance() {
		
		ServiceInstance serviceInstance = client.choose("CART-API");
		URI uri = serviceInstance.getUri();
		String url = uri+"/cart/item";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> reponse = rt.getForEntity(url, String.class);
		return reponse.getBody();
	}
}
