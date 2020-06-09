package com.lhzh.observe;

import com.lhzh.observe.IWechatGongZhong;
import com.lhzh.observe.WechatUser;

import java.util.ArrayList;
import java.util.List;

//公众号  被观察者
public class RenRenMovie implements IWechatGongZhong {

    //集合 存储 所有的观察者
    List<WechatUser> userList;

    @Override
    public void focus(WechatUser user) {
        System.out.println(user.getNickname()+"关注了人人影视");
        if(userList == null){
            userList = new ArrayList<>();
        }
        //关注的时候 把用户 放入集合
        userList.add(user);
    }

    @Override
    public void cancelFocus(WechatUser user) {
        //把用户拿出来
    }

    @Override
    public void pushMessage(String message) {
        System.out.println("公众号发送消息啦！！！！"+message);
        for (WechatUser user:userList){
            user.receiveMessage(message);
        }
    }
}
