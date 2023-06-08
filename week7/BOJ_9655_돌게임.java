package week7;

import java.util.Scanner;

public class BOJ_9655_돌게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 or 3 -> 합은 2 4 6, 홀짝
        int n = sc.nextInt();
        if (n%2==0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
