package week6.donghun;

import java.util.Scanner;

public class BOJ_10162_전자레인지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N%10 != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        int a = 300, b = 60, c = 10;
        int _a = 0, _b = 0, _c = 0;
        _a = N/a;
        _b = N%a/b;
        _c = N%a%b/c;
        System.out.println(_a+" "+_b+" "+_c);
    }
}
