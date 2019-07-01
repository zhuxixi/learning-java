package org.zhuzhenxi.test.concurrent.thread;

import java.util.List;

public class ImThread implements Runnable {

    private List<Integer> mine = null;

    public ImThread(List<Integer> a) {
        mine = a;
    }

    @Override
    public void run() {
        System.out.println("I am the one that implements Runnable");

    }
}
