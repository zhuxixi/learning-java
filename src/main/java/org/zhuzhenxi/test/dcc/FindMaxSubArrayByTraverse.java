package org.zhuzhenxi.test.dcc;

/**
 * 暴力求解最大子数组
 * @Author:Zhuxixi
 * @Description:
 * @Date:Create in  2018/11/26 9:43 PM
 */
public class FindMaxSubArrayByTraverse {
    //相等元素
    public static void main(String[] args) {

//        int[] testArray = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int[] testArray = {-12,-10,-9,-9,-10,11,12};

        SubArray result = findMaxSubArray(testArray);
        System.out.println("low:"+result.getLow());
        System.out.println("high:"+result.getHigh());
        System.out.println("value:"+result.getMaxValue());


    }

    /**
     * 寻找最大子数组
     * @param arr
     * @return
     */
    private static SubArray findMaxSubArray(int[] arr){
        int start = 0;
        int end = 0;
        //当前最大值
        int currentMaxValue = Integer.MIN_VALUE;

        //从数组第一个数开始的最大子数组
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int j = i;
            //先判断一下自己
            if (a>currentMaxValue){
                currentMaxValue=a;
                start = i;
                end = j;
            }
            j = j+1;
            while (j<arr.length){
                a += arr[j];
                if (a>currentMaxValue){
                    currentMaxValue=a;
                    start = i;
                    end = j;
                }
                j++;

            }
            
        }
        return new SubArray(start,end,currentMaxValue);

    }


}
