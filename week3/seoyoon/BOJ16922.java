package seoyoon;

import java.util.Scanner;

public class BOJ16922 {

    static boolean[] arr;
    static int[] num = {1, 5, 10, 50};
    static int N, sum, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new boolean[1001];
        N = sc.nextInt();

        dupComb(0, 0);
        System.out.println(ans);
    }

    // 중복 조합
    public static void dupComb(int cnt, int start) {
        if (cnt == N) {
            // 만들어진 로마 숫자가 중복된 값이 아니라면
            if (!arr[sum]) {
                ans++;
                arr[sum] = true;
            }
            return;
        }

        for (int i = start; i < 4; i++) {
            sum += num[i];
            dupComb(cnt + 1, i);
            sum -= num[i];
        }
    }
}
