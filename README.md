# kafka-publisher



# start zookeeper.start bat file like below
zookeeper-server-start.bat D:\kafka_2.12-2.7.0\config\zookeeper.properties

# start kafka server
kafka-server-start.bat D:\kafka_2.12-2.7.0\config\server.properties

# Create Topic:
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic kafka-prod

# Produce a message 
kafka-console-producer.bat --broker-list localhost:9092 --kafka-prod

# Consume a message
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-prod
