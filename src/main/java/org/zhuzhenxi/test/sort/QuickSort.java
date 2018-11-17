package org.zhuzhenxi.test.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> testArray = new ArrayList<>();

        for (int i = 0; i < 2000000; i++) {
            testArray.add(randomInt());
        }
        long start = System.currentTimeMillis();
        testArray = quickSort(testArray);
        long end = System.currentTimeMillis();
        System.out.println("快速排序耗时："+(end-start));//200条3毫秒，2万=50毫秒，20万500毫秒，200万=3秒
//        System.out.println(testArray);


    }


    private static List<Integer> quickSort(List<Integer> array){
        if (array.size()<2){
            return array;
        }
        int pivot0 = array.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> pivot= new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            Integer current = array.get(i);
            if (current<pivot0){
                left.add(current);
                continue;
            }
            if (current==pivot0){
                pivot.add(current);
                continue;
            }
            right.add(current);

        }
        List<Integer> left1 = quickSort(left);
        //pivot 不需要排序
        List<Integer> right1 = quickSort(right);

        left1.addAll(pivot);
        left1.addAll(right1);
        return left1;
    }
    private static int randomInt(){
        Random random = new Random();
        int x = random.nextInt(899999);
        x = x+100000;
        return x;
    }
}
