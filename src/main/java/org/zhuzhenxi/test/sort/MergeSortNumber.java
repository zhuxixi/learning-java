package org.zhuzhenxi.test.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @Author:Zhuxixi
 * @Description:
 * @Date:Create in  2018/11/21 9:57 PM
 */
public class MergeSortNumber {
    public static void main(String[] args) {
        Integer[] testArray = {40,23,33,2,21,12,32,34};

        System.out.println("排序前"+ JSON.toJSONString(testArray));
        long start = System.currentTimeMillis();
        mergeSort(testArray,0,testArray.length);
        long end = System.currentTimeMillis();
        //200条3毫秒，2万=50毫秒，20万500毫秒，200万=3秒
        System.out.println("插入排序耗时："+(end-start));
        System.out.println("排序后"+JSON.toJSONString(testArray));



    }


    /**
     * 归并排序
     * 将一个数组递归地分成两半，直到只有一个元素，比较两个数组的中唯一元素的大小
     * 递归回升
     * @param param
     */
    private static void mergeSort(Integer[] param,int start,int end){
        if ((end-start)>1){
            mergeSort(param,start,(end-start)/2);
            mergeSort(param,((end-start)/2)+1,end);
            return;
        }
        merge(param,start,(end-start)/2,end);

    }

    private static void merge(Integer[] param,int start ,int middle, int end){
        Integer[] a = {};
        Integer[] b = {};
        for (int i = 0; i < (middle-start)+1; i++) {
            a = Arrays.copyOf(a,a.length+1);
            a[i] = param[start+i];
        }
        for (int i = 0; i < (end-middle)+1; i++) {
            b = Arrays.copyOf(b,b.length+1);
            b[i] = param[middle+i];
        }


        for (int i = 0; i < (end-start)/2; i++) {
            if (a[i]<b[i]){
                param[start+i]=a[i];
                param[start+i+1]=b[i];
            }else {
                param[start+i]=b[i];
                param[start+i+1]=a[i];
            }
            i = i+1;
        }
    }
}
