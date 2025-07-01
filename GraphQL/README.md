
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
:\> curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json" -d '{"query":"{ books { title category authors { name } } }"}'
```

* Bài viết chi tiết:
  https://bimatlaptrinh.com/huong-dan-tung-buoc-xay-dung-api-graphql-voi-spring-boot-3/