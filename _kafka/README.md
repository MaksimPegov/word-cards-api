# Example of using Kafka from command line

## Start the cluster
 
docker compose pull
docker compose up -d

## Enter the container with Kafka

docker container exec -it kafka1 bash

## Create a topic

kafka-topics --create --topic pageclicks --bootstrap-server kafka1:9092 --partitions 6 --replication-factor 3

## List the topics

kafka-topics --list --bootstrap-server kafka1:9092

## Describe the topic

kafka-topics --describe --topic pageclicks --bootstrap-server kafka1:9092

```
        Topic: pageclicks       Partition: 0    Leader: 2       Replicas: 2,3,1 Isr: 2,3,1
        Topic: pageclicks       Partition: 1    Leader: 3       Replicas: 3,1,2 Isr: 3,1,2
        Topic: pageclicks       Partition: 2    Leader: 1       Replicas: 1,2,3 Isr: 1,2,3
        Topic: pageclicks       Partition: 3    Leader: 2       Replicas: 2,1,3 Isr: 2,1,3
        Topic: pageclicks       Partition: 4    Leader: 3       Replicas: 3,2,1 Isr: 3,2,1
        Topic: pageclicks       Partition: 5    Leader: 1       Replicas: 1,3,2 Isr: 1,3,2
```

## Produce and consume messages

kafka-console-producer --topic pageclicks --bootstrap-server kafka1:9092

kafka-console-consumer --topic pageclicks --bootstrap-server kafka1:9092 --from-beginning