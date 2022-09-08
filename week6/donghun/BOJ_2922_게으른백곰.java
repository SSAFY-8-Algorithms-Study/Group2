package week6.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2922_게으른백곰 {
    static int N, K;
    static int max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[1000001];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int bundle = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            arr[idx] = bundle;
        }
        // 입력 끝

        if (K >= 1000000) {
            for (int i = 0; i < arr.length; i++) {
                max += arr[i];
            }
            System.out.println(max);
            System.exit(0);
        }

        int sum = 0;
        int k = 2 * K + 1;
        for (int i = 0; i < 1000001; i++) {
            if (i >= k) {
                sum -= arr[i - k];
            }
            sum += arr[i]; // 끝을 만날때까지
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
