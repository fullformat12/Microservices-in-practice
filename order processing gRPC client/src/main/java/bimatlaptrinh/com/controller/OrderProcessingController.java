package bimatlaptrinh.com.controller;

import bimatlaptrinh.com.model.Order;
import bimatlaptrinh.com.service.InventoryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping(value = "/order")
public class OrderProcessingController {

	private final InventoryClient inventoryClient;

    public OrderProcessingController(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		
		if (order != null) {
			inventoryClient.sendItems(order.getItems());
			order.setOrderId(UUID.randomUUID().toString());
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(order.getOrderId()).toUri();
			
			return ResponseEntity.created(location).build();
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
