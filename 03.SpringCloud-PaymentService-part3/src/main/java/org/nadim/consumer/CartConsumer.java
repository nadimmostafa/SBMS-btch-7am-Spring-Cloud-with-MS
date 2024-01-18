package org.nadim.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumer {
	@Autowired
	private DiscoveryClient client;
	
	public String getCartServiceInstance() {
		List<ServiceInstance> serviceInstanceList = client.getInstances("CART-API");
		ServiceInstance si = serviceInstanceList.get(0);
		URI uri = si.getUri();
		String url = uri+"/cart/item";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> reponse = rt.getForEntity(url, String.class);
		return reponse.getBody();
	}
}
