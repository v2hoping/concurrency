package com.owl.Synchronized;

/**
 * Hello world!
 *
 */
public class LockExample
{
    public static void main( String[] args )
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Lock.printStatic();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Lock lock = new Lock();
                lock.printNotStatic();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Lock lock = new Lock();
                lock.printClassLock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Lock lock = new Lock();
                lock.printClassLock();
            }
        }).start();
    }
}
