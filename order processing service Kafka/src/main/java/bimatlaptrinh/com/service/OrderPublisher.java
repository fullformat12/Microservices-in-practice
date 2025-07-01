package bimatlaptrinh.com.service;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {
    private final StreamBridge streamBridge;
    public OrderPublisher(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void publish(Object order) {
        streamBridge.send("order-out-0", order);
    }
}
