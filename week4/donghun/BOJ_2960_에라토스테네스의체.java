package week4.donghun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2960_에라토스테네스의체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 2; i <= N; i++) {
            list.add(i);
        }

        int count = 0;
        while (true) {
            int n = list.peek();
//            System.out.println(n);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) % n == 0) {
                    K--;
                    if (K == 0) {
                        System.out.println(list.get(j));
                        System.exit(0);
                    }
                    list.remove(j);
//                    System.out.println(list);
                    j--;
                }
            }
        }
    }
}