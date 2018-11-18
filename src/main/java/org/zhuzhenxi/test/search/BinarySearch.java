package org.zhuzhenxi.test.search;

public class BinarySearch {


    public static void main(String[] args) {
//        List<Integer> testArray = new ArrayList<>();
//
//        for (int i = 0; i < 2000000; i++) {
//            testArray.add(RandomUtil.generateRandomNumber());
//        }
////        System.out.println("排序前"+testArray);
//        long start = System.currentTimeMillis();
//        testArray = quickSort(testArray);
//        long end = System.currentTimeMillis();
//        System.out.println("快速排序耗时："+(end-start));//200条3毫秒，2万=50毫秒，20万500毫秒，200万=3秒
////        System.out.println("排序后"+testArray);
//

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
