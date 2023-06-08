package week7;

import java.util.Scanner;

public class 물뿌리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n > m) {
            System.out.println(n+m+m/10);
        } else {
            System.out.println(n+m+n/10);
        }
    }
}
