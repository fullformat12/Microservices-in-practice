package bimatlaptrinh.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentMethod {

	@JsonProperty("card_type")
	private String cardType;
	@JsonProperty("expiration")
	private String expiration;
	@JsonProperty("name")
	private String name;
	@JsonProperty("billing_address")
	private String biilingAddress;
}
