package org.zhuzhenxi.test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<Integer>();
        int inputNumber = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < inputNumber; i++) {
            Scanner scanner0 = new Scanner(System.in);
                String currentInput = scanner0.nextLine();
                Set<String> currentStr = new HashSet<String>();
                String[] cur = currentInput.split(" ");
                for (int j = 0; j < cur.length; j++) {
                    if (!" ".equals(cur[j])){
                        currentStr.add(cur[j]);
                    }
                }
                result.add(currentStr.size());
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }


    }


}
