package week1.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1059 {
    static int N;
    static int key, count, start, end;

    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // start 입력
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        key = Integer.parseInt(br.readLine());
        // end 입력

        // start 로직
        Arrays.sort(arr);

        int kdx = Arrays.binarySearch(arr, key);

        if (kdx <= -1) {

            if (kdx == -1) {
                start = 0;
                end = arr[0];
            } else {
                start = arr[Math.abs(kdx) - 2];
                end = arr[Math.abs(kdx) - 1];
            }

            for (int i = start + 1; i < end - 1; i++) {
                for (int j = start + 2; j < end; j++) {
                    if (i <= key && key <= j && i < j) {
                        count++;
                    }
                }
            }
        } else {
            count = 0;
        }
        // end 로직

        // 출력
        System.out.println(count);
    }
}