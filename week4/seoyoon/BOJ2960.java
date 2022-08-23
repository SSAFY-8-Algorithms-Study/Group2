package week4.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ2960 - 에라토스테네스의 체 */
public class BOJ2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            boolean isNotPrime = false;

            for (int j = 2; j < i; j++) {    // 소수인지 체크
                if (arr[i] % j == 0) {
                    isNotPrime = true;
                    break;
                }
            }

            if (!isNotPrime) {        // 소수라면
                for (int idx = 1; i * idx <= N; idx++) {    // 해당 소수의 배수를 찾아
                    if (arr[i * idx] != 0) {
                        arr[i * idx] = 0;    // 순서대로 지움
                        cnt++;

                        if (cnt == K) {
                            System.out.println(i * idx);
                            return;
                        }
                    }
                }
            }
        }
    }
}
