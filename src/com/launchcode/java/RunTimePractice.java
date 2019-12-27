package com.launchcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RunTimePractice {

    public static int findNumberOfRepetitions(String st, char ch){
        //Linear time; 0(n) time
        int sum = 0;                        //constant      1

        /*for loop - linear; a < st.length checked n + 1 times
        * everything else in for loop checked n times
        * */
        for (int a = 0; a < st.length(); a += 1){       //1, n + 1, n
            if (st.charAt(a) == ch){        //n
                sum +=1;                //n
            }
        }
        return sum;         //constant      1
    }
    public static int[] findNumbersOfRepetitionsV1(String sr, char[] cr){
        //Quadratic (Quad)time 0(n * m)
        int[] summers = new int[cr.length];  //holds sums for each char  //1
        for (int b = 0; b < sr.length(); b +=1){        //1, n + 1, n
            for (int c = 0; c < cr.length; c +=1){      //n, n*m + 1, n*m
                if (sr.charAt(b) == cr[c]){   //n*m
                    summers[c] = summers[c] + 1;  //n*m
                }
            }
        }
        return summers;  //1
    }
    public static int[] findNumbersOfRepetitionsV2(String sn, char[] ca){
        //Optimal time 0(n + m)
        int[] sums = new int[ca.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sn.length(); i += 1){
            if (!map.containsKey(sn.charAt(i))){
                map.put(sn.charAt(i), 1);
        }else {
                int sum = map.get(sn.charAt(i));
                map.put(sn.charAt(i), sum + 1);
            }
        }
        for (int k = 0; k < ca.length; k += 1){
            int sum;
            if (!map.containsKey(ca[k])){
                sums[k] = 0;
            } else {
                sums[k] = map.get(ca[k]);
            }
        }
        return sums;
    }
    public static void runTime(){
        long startTime = System.currentTimeMillis();
        System.out.println(findNumberOfRepetitions("yayanayayyayanayayyayanayayyayanayayyayanayay", 'a'));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        if (duration == 1) {
            System.out.println("Test " + duration + " millisecond.");
        } else
            System.out.println("Test " + duration + " milliseconds.");

        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'a', 'b', 'c', 'd', 'e', 'f', 'a', 'b', 'c', 'd', 'e', 'f', 'a', 'b', 'c', 'd', 'e', 'f', 'a', 'b', 'c', 'd', 'e', 'f', 'a', 'b', 'c', 'd', 'e', 'f', 'a', 'b', 'c', 'd', 'e', 'f', 'a', 'b', 'c', 'd', 'e', 'f'};

        startTime = System.currentTimeMillis();
        System.out.println(findNumbersOfRepetitionsV1("yayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayay", a));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        if (duration == 1) {
            System.out.println("Test " + duration + " millisecond.");
        } else
            System.out.println("Test " + duration + " milliseconds.");

        startTime = System.currentTimeMillis();
        System.out.println(findNumbersOfRepetitionsV2("yayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayayyayanayay", a));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        if (duration == 1) {
            System.out.println("Test " + duration + " millisecond.");
        } else
            System.out.println("Test " + duration + " milliseconds.");
    }

    public static void main(String[] args) {
        // write your code here
        runTime();
    }
}
