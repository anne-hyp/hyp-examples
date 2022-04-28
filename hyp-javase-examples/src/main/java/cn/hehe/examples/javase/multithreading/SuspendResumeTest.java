package cn.hehe.examples.javase.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.LockSupport;

/**
 * @author hyp
 * @title: SuspendResumeTest
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/4/28 11:16
 */
public class SuspendResumeTest {
    public static Object object = new Object();
    static TestThread t1 = new TestThread("t1线程");
    static TestThread t2 = new TestThread("t2线程");

    public static class TestThread extends Thread {

        public TestThread(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(getName() + "占用。。");
//                Thread.currentThread().suspend();
                LockSupport.park();
                System.out.println(getName() + "执行完成。。");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(200);
        t2.start();
//        t1.resume();
//        t2.resume();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }

}
