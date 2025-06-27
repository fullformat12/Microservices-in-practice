
* Build dư án

```javascript
:\> mvn clean install
```

* Run

```javascript
:\> mvn spring-boot:run
```

* Test: gửi yêu cầu đến Order Service để tạo đơn hàng. Khi Order Service nhận được yêu cầu này, nó sẽ gọi Inventory Service để kiểm tra tình trạng hàng hóa.

```javascript
:\> curl -v -H "Content-Type: application/json" -d '{
"customer_id":"101021",
    "payment_method":{
    "card_type":"VISA",
        "expiration":"01/22",
        "name":"Dac Nguyen",
        "billing_address":"01, Hoan Kiem, Ha Noi"
},
"items":[
    {"code":"101", "qty":1},
    {"code":"103", "qty":5}
],
    "shipping_address":"01, Hoan Kiem, Ha Noi"
}' http://localhost:8080/order
```

* Bài viết chi tiết:
  https://bimatlaptrinh.com/ket-noi-microservices-bang-grpc-giao-tiep-hieu-nang-cao/