package bimatlaptrinh.com.service;

import bimatlaptrinh.com.model.Item;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryClient {

    @GrpcClient("inventory-service")
    private InventoryServiceGrpc.InventoryServiceBlockingStub stub;

    public void sendItems(List<Item> items) {
        ItemList.Builder builder = ItemList.newBuilder();
        items.forEach(i -> builder.addItem(
                bimatlaptrinh.com.service.Item.newBuilder()
                        .setCode(i.getCode())
                        .setQty(i.getQty())
        ));

        UpdateItemsResp resp = stub.updateItems(builder.build());
        System.out.println("Response: " + resp.getCode());
    }
}