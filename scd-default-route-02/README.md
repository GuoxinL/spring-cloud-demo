`http://127.0.0.1:9000/SCD-PROVIDER/hello?name=2312312`
`http://127.0.0.1:9000/SCD-CONSUMER/hello/xxx`

可以看出，Spring Cloud Gateway 自动的为我们的 consumer 创建了一个路由，类似于下边这样

```
routes:
  - id: CompositeDiscoveryClient_SC-CONSUMER
    uri: lb://SC-CONSUMER
    order: 0
    predicates:
      - Path=/SC-CONSUMER/**
    filters:
      - RewritePath=/SC-CONSUMER/(?<segment>.*), /$\{segment}
```