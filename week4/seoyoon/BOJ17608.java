package week4.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ17608 - 막대기 */
public class BOJ17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] bar = new int[N];
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            bar[i] = Integer.parseInt(br.readLine());
        }

        int high = bar[N - 1];      // 맨 오른쪽 막대기
        for (int i = N - 2; i >= 0; i--) {
            if (bar[i] > high) {
                cnt++;
                high = bar[i];
            }
        }
        System.out.println(cnt);
    }
}
