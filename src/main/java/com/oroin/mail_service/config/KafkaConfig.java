package com.oroin.mail_service.config;

import com.oroin.mail_service.model.UserResponse;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public Map<String, Object> baseConsumerProps() {
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"
        );
    }


    @Bean
    public ConsumerFactory<String, UserResponse> userRegisteredConsumerFactory(
            Map<String, Object> baseConsumerProps
    ) {
        JacksonJsonDeserializer<UserResponse> deserializer =
                new JacksonJsonDeserializer<>(UserResponse.class);
        deserializer.addTrustedPackages("com.oroin.events.*");

        return new DefaultKafkaConsumerFactory<>(
                baseConsumerProps,
                new StringDeserializer(),
                deserializer
        );
    }

}
