package week15.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ2688 : 줄어들지 않아 */
public class BOJ2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[][] nSumArr = new long[65][10];		// 각 자리별 들어갈 수 있는 숫자의 개수 저장
        nSumArr[1] = new long[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int n = 2; n <= 64; n++) {
            for (int idx = 0; idx < 10; idx++) {
                long sum = 0;
                for (int i = idx; i < 10; i++) {	// 전 배열의 index {0~9, 1~9, 2~9, ,,, } 까지의 각 합 구해서
                    sum += nSumArr[n - 1][i];
                }
                nSumArr[n][idx] = sum;				// 배열에 넣기
            }
        }

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(nSumArr[n][0]);
        }
    }
}
