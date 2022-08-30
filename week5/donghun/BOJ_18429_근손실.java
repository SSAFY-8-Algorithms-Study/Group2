package week5.donghun;

import java.util.Scanner;

public class BOJ_18429_근손실 {
    static int N, K, ans;
    static int[] arr, out;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        out = new int[N];
        visited = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        perm(0);
        System.out.println(ans);

    }

    static void perm(int cnt) {
        if (cnt == N) {
            int sum = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                sum += out[i] - K;
                if (sum < 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[cnt] = arr[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
