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
public class Item {

	@JsonProperty("code")
	private String code;
	@JsonProperty("qty")
	private int qty;
}
