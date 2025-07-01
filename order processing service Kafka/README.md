
* Build dư án

```javascript
:\> mvn clean install
```

* Run

```javascript
:\> mvn spring-boot:run
```

* Test

```javascript
:\> curl -v -H "Content-Type: application/json" -d '{"customer_id":"101021","payment_method":{"card_type":"VISA","expiration":"01/22","name":"Dac Nguyen","billing_address":"01, Hoan Kiem, Ha Noi"},"items":[{"code":"101","qty":1},{"code":"103","qty":5}],"shipping_address":"01, Hoan Kiem, Ha Noi"}' http://localhost:8080/order
```

* Bài viết chi tiết:
  https://bimatlaptrinh.com/xay-dung-microservices-huong-su-kien-voi-kafka/