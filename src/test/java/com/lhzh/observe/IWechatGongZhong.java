package com.lhzh.observe;

import com.lhzh.observe.WechatUser;

public interface IWechatGongZhong {
    //关注/注册
    void focus(WechatUser user);

    //注销/取关
    void cancelFocus(WechatUser user);

    //推送消息
    void pushMessage(String message);
}
