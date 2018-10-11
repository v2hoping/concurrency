package com.owl.Synchronized;

/**
 * Created by houping wang on 2018/9/29
 *
 * @author houping wang
 */
public class Lock {

    public synchronized void printNotStatic() {//new Lock();
        System.out.println("调用Lock非静态方法 befor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("调用Lock非静态方法 after");
    }

    public static synchronized void printStatic() {
        System.out.println("调用Lock静态方法 befor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("调用Lock静态方法 after");
    }
    public void printClassLock() {
        synchronized (Lock.class) { //new Class<Lock>();
            System.out.println("调用Lock动态类锁方法 befor");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("调用Lock动态类锁方法 after");
        }
    }
}
