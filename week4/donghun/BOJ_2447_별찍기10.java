package week4.donghun;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2447_별찍기10 {
    static char[][] arr;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }
        dfs(N, 0, 0);

        System.out.println(Arrays.toString(arr));
    }

    public static void dfs(int size, int ni, int nj) {
        if (size == 1) {
            arr[ni][nj] = '*';
            return;
        }
        int nextSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                dfs(nextSize, ni + (nextSize * i), nj + (nextSize * j));
            }
        }
    }
}
