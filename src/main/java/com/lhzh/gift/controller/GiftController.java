package com.lhzh.gift.controller;

import com.alibaba.fastjson.JSON;
import com.lhzh.gift.model.GiftModel;
import com.lhzh.solrdemo.BaseController;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping("/gift")
public class GiftController extends BaseController {

    @Autowired
    DefaultMQProducer producer;

    //送礼的接口
    @GetMapping("/send/{gid}/{gname}/{price}")
    public Map<String,Object> sendGift(@PathVariable("gid")Integer gid,
                                       @PathVariable("gname")String gname,
                                       @PathVariable("price")Long price){
        GiftModel giftModel = new GiftModel(gid,gname,price);
        //因为并发量过大，当前的业务无法支撑，改用mq
        String giftjson = JSON.toJSONString(giftModel);
        //创建message对象
        Message message = new Message("Gift_Topic","DemoTag",giftjson.getBytes());
        SendResult sendResult = null;
        try {
            sendResult = producer.send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return success(sendResult);
    }
}
