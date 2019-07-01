package org.zhuzhenxi.test.concurrent.thread;

import java.util.List;

public class MyThread extends Thread {

    private List<Integer> mine = null;

    public MyThread(List<Integer> a){
        mine = a;
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
       System.out.println("I am the one that extends Thread");

    }

}
