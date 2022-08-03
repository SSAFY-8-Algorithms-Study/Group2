package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());
        int start = 0, end = 1001;
        int ans = 0;

        for (int i = 0; i < L; i++) {
            if (arr[i] < n) {
                if (arr[i] > start) start = arr[i];
            } else if (arr[i] > n) {
                if (arr[i] < end) end = arr[i];
            } else {
                System.out.println(0);
                return;
            }
        }

        for (int j = start + 1; j <= n; j++) {
            for (int k = n; k < end; k++) {
                if (j != k) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
