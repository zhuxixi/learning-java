package org.zhuzhenxi.test.search;

/**
 * 二分查找
 */
public class BinarySearch {


    public static void main(String[] args) {

    }
    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (key < arr[middle]) {
                end = middle - 1;
                continue;
            }
            if (key > arr[middle]) {
                start = middle + 1;
                continue;
            }
            return middle;
        }
        return -1;
    }
}
