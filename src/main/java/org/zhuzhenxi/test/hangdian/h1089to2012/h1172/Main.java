package org.zhuzhenxi.test.hangdian.h1089to2012.h1172;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int lines = scanner.nextInt();
            List<GuessResult> guessResults = new ArrayList<>();
            while (lines>0&&scanner.hasNext()){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                guessResults.add(new GuessResult(a,b,c));
                lines--;
            }
            Calculator cl = new Calculator(guessResults);
            cl.clearNoNeed();
            cl.tryToMakeSure();


        }
    }

    private static class Calculator{
        private List<Integer> pool = new ArrayList<>();

        private List<GuessResult> results = new ArrayList<>();

        private String result = "Not sure";
        private int[] resultPool = new int[4];

        public Calculator(List<GuessResult> results1){
            pool.add(0);
            pool.add(1);
            pool.add(2);
            pool.add(3);
            pool.add(4);
            pool.add(5);
            pool.add(6);
            pool.add(7);
            pool.add(8);
            pool.add(9);
            results.addAll(results1);
        }


        public void clearNoNeed(){
            Iterator<GuessResult> it = results.iterator();
            while (it.hasNext()){
                GuessResult c  = it.next();
                if (c.getRightBit() == 0&&c.getRightLocation()==0){
                    int[] canClear = spilt(c.getGuess());
                    for (int i = 0; i < canClear.length; i++) {
                        pool.remove(canClear[i]);
                    }
                    it.remove();
                }
            }
        }

        public void tryToMakeSure(){
            for (int i = 0; i < results.size(); i++) {
                
            }
        }

        private int[] spilt(int num){
            int[] result = new int[4];
            result[0] = num/1000;
            result[1] = num%(result[0]*1000)/100;
            result[2] = num%(result[0]*1000+result[1]*100)/10;
            result[3] = num%(result[0]*1000+result[1]*100+result[2]*10);
            return result;
        }
    }

    private static class GuessResult{
        private int guess;
        private int rightBit;
        private int rightLocation;

        public GuessResult(int guess1,int rightBit1,int rightLocation1){
            guess = guess1;
            rightBit = rightBit1;
            rightLocation = rightLocation1;
        }

        public int getGuess() {
            return guess;
        }

        public void setGuess(int guess) {
            this.guess = guess;
        }

        public int getRightBit() {
            return rightBit;
        }

        public void setRightBit(int rightBit) {
            this.rightBit = rightBit;
        }

        public int getRightLocation() {
            return rightLocation;
        }

        public void setRightLocation(int rightLocation) {
            this.rightLocation = rightLocation;
        }
    }
}
