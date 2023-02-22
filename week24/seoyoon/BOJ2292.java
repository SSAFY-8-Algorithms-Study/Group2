package week24.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 벌집 */
public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (3 * (i - 1) * (i) < (n - 1) && (n - 1) <= 3 * i * (i + 1)) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
