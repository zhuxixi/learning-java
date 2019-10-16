package org.zhuzhenxi.test.learning.jdk8.thread;

/**
 *
 */
public class ThreadStateNewExample {
    private static Object waiter = new Object();

    public static void main(String[] args){
        Runnable waiting = () -> {
            try{
                waiter.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Thread whoWillWait = new Thread(waiting);
        System.out.printf(whoWillWait.getState().toString());
    }
}
