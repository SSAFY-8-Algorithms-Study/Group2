package week6.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // End Input

        Arrays.sort(arr, ((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        }));

        int max = Integer.MIN_VALUE;
        int dis = 2 * K + 1;
        int i = 0, start = 0, sum = 0;

        while(i < N) {
            // 2K+1 거리를 넘는다면
            if (arr[i][1] <= arr[start][1] + dis) {
                sum += arr[i][0];
                i++;
                if (sum > max) {
                    max = sum;
                }
            } else {
                sum -= arr[start][0];
                start++;
            }
        }
        System.out.println(max);
    }
}