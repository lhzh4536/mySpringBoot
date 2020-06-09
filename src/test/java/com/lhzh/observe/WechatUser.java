package com.lhzh.observe;

//观察者
public class WechatUser {

    private String nickname;//昵称
    private String headPic;
    private Integer isReceive = 0 ;//0接收 1屏蔽

    //获得消息之后的处理
    //当观察者 观察到 被观察者 的变化的时候，如何处理
    public void receiveMessage(String message){
        if(isReceive == 0){
            System.out.println(nickname+"您获得一条消息："+message);
        }
    }

    public WechatUser(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
}
