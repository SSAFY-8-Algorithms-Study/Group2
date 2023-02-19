package week24.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {

    /**
     * Tier: BRONZE 2
     * Title: 벌집
     * Category: 수학
     *
     * 벌집의 레벨이 증가할수록 육각형의 개수는 6의 배수로 증가한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
        } else {
            int num = 1;
            int cnt = 1;
            while (true) {
                if (N <= num + 6*cnt) {
                    System.out.println(cnt+1);
                    break;
                }
                num += 6*cnt;
                cnt++;
            }
        }
    }
}
