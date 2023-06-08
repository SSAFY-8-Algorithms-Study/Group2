package week38.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합_S3 {
    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        ///////////////// end input
        //////////////// start logic

        int count = 0;
        int fixVal = 0;

        for (int fix = 0; fix < n; fix++) { // 고정된 포인터
            fixVal = arr[fix];

            for (int move = fix + 1; move < n; move++) { // 이동할 포인터
                if (fixVal + arr[move] == x) {
                    count++;
                } else if (fixVal + arr[move] > x) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
