package bimatlaptrinh.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("payment_method")
	private PaymentMethod paymentMethod;
	@JsonProperty("items")
	private List<Item> items;
	@JsonProperty("shipping_address")
	private String shipppingAddress;

}
