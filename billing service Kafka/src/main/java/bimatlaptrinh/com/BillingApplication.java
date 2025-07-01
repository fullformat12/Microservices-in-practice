package bimatlaptrinh.com;

import bimatlaptrinh.com.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }
    @Bean
    public Consumer<Order> orderCompleted() {
        return order -> {
            System.out.println("Thanh toan cho order: " + order.getOrderId());
        };
    }

}
