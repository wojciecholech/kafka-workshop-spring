# Kafka - Spring

Build project
```sh
./gradlew clean build
```

Start project
```sh
./gradlew clean build
docker-compose up --no-deps --build
```

Stop
```sh
docker-compose down
```

### kafdrop
http://localhost:9000/

### Commands
* Publish to particular partition
  * http://localhost:8080/publish/{partition no: 0..n}
* Publish batch with key
  * http://localhost:8080/batch/


### Exercise #1
* Write producer using Spring Kafka integration
* Write consumer using Spring Kafka integration
* Log received message
```sh
  * log.info( "Received Message: {} from partition:{} offset:{} ", message, partition, offsets);
```

### Exercise #2
* Produce message in synchronous manner
* Test Producer Callback
* Produce message to not existing partition

### Exercise #3
* Create topic with single partition
* Produce messages with unique key
* Start multiple app instances (3) with the same consumer group ID and observe how messages are being consumed.

### Exercise #4
* Create topic with 10 partitions
* Produce message with unique key, so they are distributed across all partitions
* Start multiple app instances (3) with the same consumer group ID and observe how messages are being consumed.

### Exercise #5
* Committing Offsets
* https://docs.spring.io/spring-kafka/docs/2.2.6.RELEASE/reference/html/#committing-offsets

### Exercise #6
* Write and read JSON objects

### Exercise #7
* Schema registry
https://docs.confluent.io/platform/current/schema-registry/index.html

### Reference
https://docs.confluent.io/clients-kafka-java/current/overview.html#java-installation
https://developer.confluent.io/tutorials/