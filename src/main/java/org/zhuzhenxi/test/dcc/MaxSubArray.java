package org.zhuzhenxi.test.dcc;

import com.alibaba.fastjson.JSON;

/**
 * 最大子数组问题
 * @Author:Zhuxixi
 * @Description:
 * @Date:Create in  2018/11/24 2:18 PM
 */
public class MaxSubArray {
    public static void main(String[] args) {
//        int[] testArray = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int[] testArray = {-9,-9,10,11};

        SubArray result = findMaxSubArray(testArray,0,testArray.length-1);
        System.out.println("最终结果："+ JSON.toJSONString(result));

    }

    private static SubArray findMaxSubArray(int[] arr,int start ,int end){
        if (start==end){
            return new SubArray(start,end,arr[start]);
        }
        int middle = (start+end)/2;
        SubArray maxLeft = findMaxSubArray(arr,start,middle);
        SubArray maxRight = findMaxSubArray(arr,middle+1,end);
        SubArray maxCrossMiddle = findMaxCrossingSubArray(arr,start,middle,end);

        SubArray result = new SubArray(maxLeft.getLow(),maxLeft.getHigh(),maxLeft.getMaxValue());

        if (maxRight.getMaxValue()>result.getMaxValue()){
            result = maxRight;
        }
        if (maxCrossMiddle.getMaxValue()>result.getMaxValue()){
            result = maxCrossMiddle;
        }
        return result;


    }



    /**
     * 必须跨越中点的最大子数组
     * @param arr
     * @param start
     * @param middle
     * @param end
     */
    private static SubArray findMaxCrossingSubArray(int[] arr, int start, int middle, int end) {
        int maxLeft = Integer.MIN_VALUE;
        int currentLeft = 0;
        int maxLeftIndex = 0;
        for (int i = middle; i > start; i--) {
            currentLeft = currentLeft + arr[i];
            if (currentLeft > maxLeft) {
                maxLeft = currentLeft;
                maxLeftIndex = i;
            }
        }
        int maxRight = Integer.MIN_VALUE;
        int currentRight = 0;
        int maxRightIndex = 0;
        for (int i = middle + 1; i < end; i++) {
            currentRight = currentRight + arr[i];
            if (currentRight > maxRight) {
                maxRight = currentRight;
                maxRightIndex = i;
            }
        }
        int finalSum = maxRight+maxLeft;
        SubArray result = new SubArray(maxLeftIndex, maxRightIndex, finalSum);

        //如果maxLeft 和 maxRight 都是初始值，说明没进for循环,也就是当前start 和 end 是连续的两个值，
        if (maxLeft == Integer.MIN_VALUE && maxRight == Integer.MIN_VALUE) {
            //两个元素比较的话，跨过中点的最大子数组就是两个元素的合
            finalSum = arr[start]+arr[end];
            result.setMaxValue(finalSum);
            return result;
        }

        //如果maxLeft 和 maxRight 都不是初始值,那么直接将两个值相加即可
        if (maxLeft != Integer.MIN_VALUE && maxRight != Integer.MIN_VALUE) {
            finalSum = maxLeft + maxRight;
            result.setMaxValue(finalSum);
            return result;
        }
        //放法走到这里，说明maxLeft 和 maxRight 有一个是初始值
        if (maxLeft != Integer.MIN_VALUE) {
            System.out.println("maxRight是初始值");
            finalSum = maxLeft;
            result.setMaxValue(finalSum);
            return result;
        }
        System.out.println("maxRight是初始值");
        finalSum = maxRight;
        result.setMaxValue(finalSum);
        return result;

    }


    public static class SubArray{
        private int low;
        private int high;
        private int maxValue;

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }

        public SubArray(){

        }

        public SubArray(int low1, int high1, int maxValue1){
            low = low1;
            high =high1;
            this.maxValue = maxValue1;

        }
    }
}
