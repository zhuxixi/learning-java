package org.zhuzhenxi.test.hangdian.AplusBProblemII;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.*;

/**
 * @Author:Zhuxixi
 * @Description:
 * @Date:Create in  2018/12/9 6:52 PM
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNextLine()) {
            Map<Integer, String> result = new LinkedHashMap<>();
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

                System.out.println(ab[0] + " + " + ab[1] + " = " + resultstr);
                if (index!=mirror){
                    System.out.println();
                }
                index++;
                linesNum--;
            }

//            for (Map.Entry<Integer, String> entry : result.entrySet()) {
//
//                System.out.println("Case " + entry.getKey() + ":");
//                System.out.println(entry.getValue());
//                if (entry.getKey() != mirror) {
//                    System.out.println();
//                }
//            }
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

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        BigInteger a;
//        BigInteger b;
//
//        for (int i=0;i<n;i++) {
//            a = scanner.nextBigInteger();
//            b = scanner.nextBigInteger();
//
//            System.out.println("Case "+(i+1)+":");
//            System.out.print(a+" "+"+"+" "+b+" "+"="+" ");;
//            System.out.println(a.add(b));
//            if (i!=n-1) {
//                System.out.println();
//            }
//        }
//    }
}
