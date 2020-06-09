package com.lhzh.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

//生产者
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException, UnsupportedEncodingException {
        //声明一个 生产者对象
        DefaultMQProducer producer = new DefaultMQProducer("javasm_producer");
        //设置nameservice
        producer.setNamesrvAddr("192.168.12.97:9876");
        //调用方法启动
        producer.start();

        //发消息
        for(int i=0;i<50;i++){
            //创建消息对象
            Message msg = new Message("TopicTest","TagA",("Hello "+i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            //接受 响应
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        //关闭
        producer.shutdown();
    }

}
