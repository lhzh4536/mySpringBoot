package com.lhzh.gift.mq;

import com.alibaba.fastjson.JSON;
import com.lhzh.gift.model.GiftModel;
import com.lhzh.gift.service.IGiftService;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GiftConsumerListener implements MessageListenerConcurrently {
    //调用service
    @Autowired
    IGiftService giftService;
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

        if(list == null || list.isEmpty()){
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        //获得消息body
        MessageExt messageExt = list.get(0);
        //把mq中获得的消息转变成字符串,messageExt.getBody()是byte数组
        String giftmessage = new String(messageExt.getBody());
        if(giftmessage ==null || giftmessage.isEmpty()){
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        //把json转换成实体类
        GiftModel giftModel = JSON.parseObject(giftmessage,GiftModel.class);
        //调用送礼的方法
        giftService.sendGift(giftModel);

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
