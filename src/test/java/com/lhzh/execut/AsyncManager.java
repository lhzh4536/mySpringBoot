package com.lhzh.execut;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

//线程池
public class AsyncManager {
    //变成单例
    private AsyncManager(){}

    private static AsyncManager asyncManager = new AsyncManager();

    public static AsyncManager getInstance(){
        return asyncManager;
    }

    //声明一个变量
    private Executor executor;

    //线程池初始化，规定线程池中 默认有几个线程
    public void init(int threadNum){
        //创建线程池的工厂
        ThreadPoolTaskExecutor taskExecutor =new ThreadPoolTaskExecutor();

        this.executor = Executors.newFixedThreadPool(threadNum, new ThreadFactory() {
            //初始化线程池组
            ThreadGroup threadGroup = new ThreadGroup("AsyncManager");
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(threadGroup,r);
            }
        });
    }
    //执行的方法 调用线程池
    public void execute(Runnable runnable){
        executor.execute(runnable);
    }

}
