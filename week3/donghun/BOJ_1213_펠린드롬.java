package week3.donghun;

import java.util.Scanner;

public class BOJ_1213_펠린드롬 {
    static int[] abc = new int[26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        for (int i = 0; i < line.length(); i++) {
            int idx = line.charAt(i) - 'A';
            abc[idx]++;
        }

        int sumCheck = 0;
        int oddIdx = 0;
        for (int i = 0; i < abc.length; i++) {
            if (abc[i] % 2 == 1) {
                sumCheck++;
                oddIdx = i;
            }
        }

        if (sumCheck > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < abc.length; i++) {
                for (int j = 0; j < abc[i]/2; j++) {
                    System.out.print((char)(i+'A'));
                }
            }

            if (sumCheck==1)
            System.out.print((char)(oddIdx+'A'));

            for (int i = abc.length - 1; i >= 0; i--) {
                for (int j = 0; j < abc[i]/2; j++) {
                    System.out.print((char)(i+'A'));
                }
            }
        }
    }
}