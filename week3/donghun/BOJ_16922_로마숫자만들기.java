package week3.donghun;

import java.util.Scanner;

public class BOJ_16922_로마숫자만들기 {
    /**
     * 중복순열 nHr = (i, depth+1, sum+rome[i])
     */
    static int[] rome = {1, 5, 10, 50};
    static int[] arr;
    static boolean[] visited;
    static int N, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[1001]; // L 20개

        search(0, 0, 0);
        System.out.println(ans);
    }

    static void search(int index, int depth, int sum) {
        if (depth == N) {
            if (!visited[sum]) {
                visited[sum] = true;
                ans++;
            }
            return;
        }
        for (int i = index; i < rome.length; i++) {
            search(i, depth + 1, sum + rome[i]);
        }
    }
}
