package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] kn = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] goatWeight = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(goatWeight);

        int cap = goatWeight[goatWeight.length-1];
        int goatLength = goatWeight.length-1;
        boolean check = true;
        int answer = 0;



        while (true){
            int currentCap = 0;
            answer = 0;
            int[] mockGoats = new int[goatLength+1];
            for (int i = 0; i < mockGoats.length; i ++){
                mockGoats[i] = goatWeight[i];
            }
            int zeroCount = 0;

            while (zeroCount != goatLength+1) {
                currentCap = 0;
                for (int i = goatLength; i >= 0; i--) {
                    if (currentCap + mockGoats[i] <= cap && mockGoats[i] != 0) {
                        currentCap += mockGoats[i];
                        mockGoats[i] = 0;
                        zeroCount++;
                    }
                }
                answer++;
            }

            if (answer == kn[1]){
                break;
            }

            cap++;
        }

        System.out.println(cap);


    }
}