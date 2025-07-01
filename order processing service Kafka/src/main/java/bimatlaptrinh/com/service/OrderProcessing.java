package bimatlaptrinh.com.service;

import bimatlaptrinh.com.model.Item;
import bimatlaptrinh.com.model.Order;
import bimatlaptrinh.com.model.PaymentMethod;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/order")
public class OrderProcessing {

	private final OrderPublisher publisher;

    public OrderProcessing(OrderPublisher publisher) {
        this.publisher = publisher;
    }

    @RequestMapping(value = "/{id}/status", method = RequestMethod.GET)
	public ResponseEntity<?> checkOrderStatus(@PathVariable("id") String orderId) {
		return ResponseEntity.ok("{'status' : 'shipped'}");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable("id") String orderId) {
		Item book1 = new Item("101", 1);
		Item book2 = new Item("103", 5);
		PaymentMethod myvisa = new PaymentMethod("VISA", "01/22", "Dac Nguyen", "201, 1st Hoan Kiem");
		Order order = new Order("101021", orderId, myvisa, new Item[] { book1, book2 },
				"201, 1st Hoan Kiem");
		return ResponseEntity.ok(order);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(@RequestBody Order order) {

		if (order != null) {
			RestTemplate restTemplate = new RestTemplate();
			URI uri = URI.create("http://localhost:9000/inventory");
			restTemplate.put(uri, order.getItems());

			order.setOrderId(UUID.randomUUID().toString());
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(order.getOrderId()).toUri();
			publisher.publish(order);
			return ResponseEntity.created(location).build();
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
