package week14.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[N];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i < N; i++) {
            if(arr[i] == 0 && memo[i - 1] == Integer.MAX_VALUE) continue;

            for (int j = 0; j < arr[i - 1]; j++) {
                if (i + j < N) {
                    if (memo[i + j] == Integer.MAX_VALUE && memo[i - 1] == Integer.MAX_VALUE) break;
                    if (memo[i - 1] + 1 < memo[i + j]) {
                        memo[i + j] = memo[i - 1] + 1;
                    }
                }
            }
        }
        System.out.println(memo[N - 1] == Integer.MAX_VALUE ? -1 : memo[N - 1]);
    }
}
