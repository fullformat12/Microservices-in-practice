package bimatlaptrinh.com.service;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import proto.api.InventoryServiceGrpc;
import proto.api.ItemList;
import proto.api.UpdateItemsResp;

@GrpcService
public class InventoryServiceImpl extends InventoryServiceGrpc.InventoryServiceImplBase {

    @Override
    public void updateItems(ItemList request, StreamObserver<UpdateItemsResp> responseObserver) {
        request.getItemList().forEach(item -> {
            System.out.println("Received: " + item.getCode());
        });
        responseObserver.onNext(UpdateItemsResp.newBuilder().setCode("success").build());
        responseObserver.onCompleted();
    }
}
