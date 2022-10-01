package week9.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기_S2 {
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

        long ans = bsearch(0, N - 1);
        System.out.println(ans);
    }

    static long bsearch(int l, int r) {
        long sum = 0;
        long height = 0;

        long temp = 0;

        while (l < r - 1) {

            Info info = cut(l, r);
            sum = info.sum;
            height = info.height;
            int m = (int)info.m;

            if (sum > M) {
                l = m + 1;
            } else if (sum < M) {
                r = m;
            } else {
                return height;
            }
            temp = m;
        }

        long[] arr2 = Arrays.copyOfRange(arr, (int) temp, arr.length);
        return bsearch2(arr2, 0, arr2[arr2.length - 1]);

//        return height;
    }

    static long bsearch2(long[] arr2, long l, long r) {
        long height = 0;
        while (l < r) {
            long sum = cut2(l, r);

            height = (l+r)/2;

            if (sum > M) {
                l = height + 1;
            } else if (sum < M) {
                r = height;
            } else {
                l = height+1;
            }
        }
        return l-1;
    }

    static Info cut(int l, int r) {
        long sum = 0;
        long height = 0;
        int m = (l + r) / 2;

        for (int i = m + 1; i <= r; i++) {
            sum += arr[(int) i]; // 더 큰 나무의 합
        }

        sum -= arr[(int) m] * (r - m); // 밑동짤
        height = arr[(int) m];

        return new Info(sum, height, m);
    }

    static long cut2(long l, long r) {
        long sum = 0;

        long m = (l + r) / 2;

        for (int i = 0; i < N; i++) {
            if (arr[i] > m) {
                sum += arr[i] - m;
            }
        }

        return sum;
    }

    static class Info {
        long height;
        long sum;
        long m;

        public Info(long height, long sum) {
            this.height = height;
            this.sum = sum;
        }

        public Info(long height, long sum, long m) {
            this.height = height;
            this.sum = sum;
            this.m = m;
        }
    }
}
