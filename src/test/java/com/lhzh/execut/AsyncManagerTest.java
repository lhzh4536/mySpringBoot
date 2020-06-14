package com.lhzh.execut;

import com.lhzh.execut.AsyncManager;

public class AsyncManagerTest {
    public static void main(String[] args) {
        //初始化线程池
        AsyncManager.getInstance().init(5);
        AsyncManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("------------");
            }
        });
    }
}
