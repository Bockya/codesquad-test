package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int N = sc.nextInt();
        String LR = sc.next();
        String result = checkLR(word, N, LR);
        System.out.println(result);
    }
    //이동방향 확인
    private static String checkLR(String word, int N, String LR) {
        String newWord = "";
        while (N != 0) {
            int shift = N % word.length();
            if (shift >= 0) {
                if (LR.equalsIgnoreCase("L"))
                    newWord = shiftLeft(word, shift);
                if (LR.equalsIgnoreCase("R"))
                    newWord = shiftRight(word, shift);
            }
            if (shift < 0) {
                shift = -shift;
                if (LR.equalsIgnoreCase("L"))
                    newWord = shiftRight(word, shift);
                if (LR.equalsIgnoreCase("R"))
                    newWord = shiftLeft(word, shift);
            }
            N /= word.length();
        }
        return newWord;
    }
    //왼쪽으로 이동
    private static String shiftRight(String s, int n) {
        return shiftLeft(s, s.length() - n);
    }
    //오른쪽으로 이동
    private static String shiftLeft(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
