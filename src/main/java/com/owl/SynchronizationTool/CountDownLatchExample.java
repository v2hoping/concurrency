package com.owl.SynchronizationTool;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by houping wang on 2019/2/18
 *
 * @author houping wang
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        Task.timesTask(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行方法");
            }
        });
    }

    public static class Task {

        public static void timesTask(int taskCount, final Runnable runnable) throws InterruptedException {
            final CountDownLatch startLatch = new CountDownLatch(1);
            final CountDownLatch endLatch = new CountDownLatch(taskCount);
            final Random random = new Random();
            //启动线程
            for(int i = 0; i < taskCount; i ++) {
                Thread thread = new Thread( i+"") {
                    @Override
                    public void run() {
                        try {
                            startLatch.await();
                            try{
                                int sleepTime = random.nextInt(10);
                                System.out.println("线程" + this.getName() + "启动，等待" + sleepTime + "秒");
                                Thread.sleep(sleepTime * 1000);
                                runnable.run();
                            }finally {
                                endLatch.countDown();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
            //执行开始闭锁
            System.out.println("解除开始闭锁");
            startLatch.countDown();
            //执行结束闭锁
            System.out.println("等待各个线程启动，开启结束闭锁");
            endLatch.await();
            System.out.println("解除结束闭锁");
        }
    }
}
