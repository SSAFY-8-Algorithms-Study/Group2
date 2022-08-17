package week3.donghun;

import java.util.Scanner;

public class BOJ_1193_분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int X = sc.nextInt();
        int row = 0;
        int count = 0;
        for (int i = 0; i < 10000000; i++) {
            row++;
            count += row;
            if (count >= X) {
                if (i % 2 == 1) {
                    System.out.println(X - count + row + "/" + (count - X + 1));
                } else {
                    System.out.println((count - X + 1) + "/" + (X - count + row));
                }
                break;
            }
        }
    }
}
