package org.zhuzhenxi.test.hangdian.AplusBProblemII;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Author:Zhuxixi
 * @Description:
 * @Date:Create in  2018/12/9 6:52 PM
 */
public class Main {

    /**
     * 如果输入003
     * char[0] 是0，所以大数组相加需要数组反向遍历相加
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNextLine()) {
            int index = 1;
            int linesNum = Integer.parseInt(in.nextLine());
            if (linesNum>20||linesNum<1){
                continue;
            }
            int mirror = linesNum;
            while (linesNum > 0&&in.hasNextLine()) {
                String str = in.nextLine();
                String[] ab = str.split(" ");
                char[] a1char = ab[0].toCharArray();
                char[] b1char = ab[1].toCharArray();
                a1char = filter0(a1char);
                b1char = filter0(b1char);
                int a1charLenth = a1char.length;
                int b1charLenth = b1char.length;
                if (a1charLenth>1000||b1charLenth>1000){
                    continue;
                }
                int a1largerThanb1 = a1charLenth - b1charLenth;
                char[] resultchar = null;
                if (a1largerThanb1>0) {
                    resultchar = sum(a1char,b1char,a1largerThanb1);
                } else {
                    resultchar = sum(b1char,a1char,a1largerThanb1*-1);
                }
                String resultstr = new String(resultchar);

                System.out.println("Case " + index + ":");

                System.out.println(new String(a1char) + " + " + new String(b1char) + " = " + resultstr);
                if (index!=mirror){
                    System.out.println();
                }
                index++;
                linesNum--;
            }
        }

    }

    private static char[] sum(char[] shorter,char[] large,int cut){
        int forward = 0;
        for (int i = large.length-1; i >= 0; i--) {
            int sum = forward;
            if ((i-cut) > (shorter.length-1)){

            }else {
                int b = char2int(shorter[i-cut]);
                sum += b;
            }
            int a = char2int(large[i]);
            sum += a;
            forward = sum / 10;
            large[i] = int2char(sum % 10);
        }
        if (forward>0){
            char[] result = new char[large.length+1];
            result[0] = int2char(forward);
            for (int i = 1; i < result.length; i++) {
                result[i] = large[i-1];
            }
            large = result;
        }
        return large;
    }

    private static int char2int(char input){
        return (int)input - (int)'0';
    }

    private static char int2char(int input){
        return(char)(input + '0');
    }

    private static char[] filter0(char[] chars){
        int num0 = 0;
        for (int i = 0; i < chars.length; i++) {
            if(char2int(chars[i])==0){
                num0++;
            }
        }
        char []result0 = new char[chars.length-num0];
        for (int i = num0; i < chars.length; i++) {
            result0[i-num0] = chars[i];
        }
        return result0;
    }
}
