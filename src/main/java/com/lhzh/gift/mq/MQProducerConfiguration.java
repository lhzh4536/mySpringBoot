package com.lhzh.gift.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class MQProducerConfiguration {

    @Value("${javasm.producer.groupName}")
    private String groupName;

    @Value("${javasm.producer.namesrvAddr}")
    private String namesrvAddr;

    @Bean
    public DefaultMQProducer getRocketMQProducer(){
        DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(this.namesrvAddr);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return producer;
    }
}
