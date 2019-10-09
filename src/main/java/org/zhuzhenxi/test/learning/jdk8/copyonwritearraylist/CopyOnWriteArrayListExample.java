package org.zhuzhenxi.test.learning.jdk8.copyonwritearraylist;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CopyOnWriteArrayList的一个使用场景就是内存缓存
 * @author zhuzh
 * @date 2019.10.09
 */
public class CopyOnWriteArrayListExample {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10,50,5, TimeUnit.MINUTES,new LinkedBlockingDeque<>());

    private static CopyOnWriteArrayList<Dictionary> copyOnWriteArrayList = new CopyOnWriteArrayList<>(new ArrayList<>(300));

    public static void main(String[] args){

    }

}
