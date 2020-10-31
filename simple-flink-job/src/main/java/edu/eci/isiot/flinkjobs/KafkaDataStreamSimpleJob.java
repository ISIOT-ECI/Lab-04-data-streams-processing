package edu.eci.isiot.flinkjobs;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Properties;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

public class KafkaDataStreamSimpleJob {

    public static void main(String[] args) throws Exception {
                
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "kafka:9092");
        properties.setProperty("zookeeper.connect", "zookeeper:2181");
        properties.setProperty("group.id", "test");

        FlinkKafkaConsumer<String> kafkaConsumer = new FlinkKafkaConsumer<>(
                "THE-KAFKA-TOPIC",
                new SimpleStringSchema(),
                properties);

        kafkaConsumer.setStartFromEarliest();

        DataStream<String> kafkaTopicDataStream = env.addSource(kafkaConsumer);

        //TODO define datastream processing graph
        
        env.execute();
    }
}
