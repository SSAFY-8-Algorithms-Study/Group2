package week9.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기_S2_refact {
    static int N, M;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long ans = bsearch(0, arr[N - 1]);
        System.out.println(ans);
    }

    static long bsearch(long l, long r) {

        long height = 0;
        outer:
        while (l < r) {
            height = (l + r) / 2;

            long sum = 0;
            for (int j=N-1; j >= 0; j--) {
                if (arr[j] > height) {
                    sum += arr[j] - height;
                    if (sum > M) {
                        l = height + 1;
                        continue outer;
                    }
                }
            }

            if (sum == M) {
                l = height + 1;
                break;
            } else if (sum < M) {
                r = height;
            }
        }
        return l-1;
    }
}
