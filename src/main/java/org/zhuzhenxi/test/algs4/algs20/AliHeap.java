package org.zhuzhenxi.test.algs4.algs20;

import java.util.Arrays;

/**
 * @author zhuzhenxi
 * @date 2019.04.24
 */
public class AliHeap {

    public static void main(String[] args) {
        AliHeap heap = new AliHeap();
        heap.insert(10);
        System.out.println(Arrays.toString(heap.getA()));
        heap.insert(3);
        System.out.println(Arrays.toString(heap.getA()));
        heap.insert(8);
        System.out.println(Arrays.toString(heap.getA()));
        heap.insert(9);
        System.out.println(Arrays.toString(heap.getA()));

    }

    /**
     * 存数据的数据结构
     */
    private int[] a;

    private int realLength = 1;

    public int[] getA() {
        return a;
    }

    /**
     * 无参的构造方法
     * 默认初始化数组大小，10
     */
    public AliHeap(){
        a = new int[10];
    }

    /**
     * 初始化大小
     * @param size capacity
     */
    public AliHeap(int size){
        a = new int[size];
    }

    /**
     * 直接初始化入参
     * @param a1
     */
    public AliHeap(int[] a1){
        a = a1;
    }

    public void insert(int a1){
        a[realLength] = a1;
        swim(realLength++);
    }

    /**
     * 返回最大元素
     * @return
     */
    public int max(){
        return 0;
    }

    /**
     * 删除并返回最大元素
     * @return
     */
    public int delMax(){
        return 0;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty(){
        if (a == null){
            return true;
        }
        return a.length==0;
    }

    public int size(){
        if (a==null){
            return 0;
        }
        return a.length;
    }

    /**
     * 关键方法，上浮
     * @param k
     */
    private void swim(int k)
    {
        while (k > 1 && a[k/2]<a[k])
        {
            int temp = a[k/2];
            a[k/2] = a[k];
            a[k] = temp;
            k = k/2;
        }
    }


}
