package com.project.StoryModule.config;

import com.project.StoryModule.domain.Story;
import com.project.helloworld.dto.StoryDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory<String, StoryDto> storyDtoConsumer(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "dev-group");

        return new DefaultKafkaConsumerFactory<>(
                configs,
                new StringDeserializer(),
                new JsonDeserializer<>(StoryDto.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StoryDto> storyListner(){
        ConcurrentKafkaListenerContainerFactory<String, StoryDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(storyDtoConsumer());
        return factory;
    }

}
