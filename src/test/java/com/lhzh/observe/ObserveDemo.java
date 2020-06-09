package com.lhzh.observe;

import com.lhzh.observe.IWechatGongZhong;
import com.lhzh.observe.RenRenMovie;
import com.lhzh.observe.WechatUser;

public class ObserveDemo {

    public static void main(String[] args) {
        IWechatGongZhong renren = new RenRenMovie();

        renren.focus(new WechatUser("小黑"));
        renren.focus(new WechatUser("葬爱家族"));
        renren.focus(new WechatUser("小白"));
        renren.focus(new WechatUser("祖安玩家"));

        renren.pushMessage("西部世界结束了");
    }
}
