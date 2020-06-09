package com.lhzh.gift.service;

import com.lhzh.gift.model.GiftModel;
import org.springframework.stereotype.Service;

@Service
public class GiftServiceImpl implements IGiftService {
    @Override
    public void sendGift(GiftModel giftModel) {
        //发送消息给聊天服务器
        //多线程操作
            //修改redis缓存
            //存入数据库
            //排行榜变动
            //检查经验是否升级
        System.out.println(giftModel.getGname()+"----------------处理送礼的具体业务");

    }


}
