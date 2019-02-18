package com.owl.ConcurrentContainer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by houping wang on 2019/2/18
 *
 * @author houping wang
 */
public class ThreadInterruptExample {

    public static void main(String[] args) {
        Thread a = new Thread(new MyThread());
    }

    public static class MyThread implements Runnable {

        @Override
        public void run() {

        }
    }
}
