package group.week14;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1670_정상회담2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N + 1];
        // dp[0] = 0;
        // dp[2] = 1;
        // dp[4] = dp[2] + dp[2];
        // dp[6] = (dp[2]*dp[4]) + (dp[4]*dp[2];
        // dp[8] = (dp[2]*dp[6]) + (dp[4]*dp[4] + (dp[6]*dp[2]))
        dp[0] = 1; // 대체 왜 얘가 1? 점화식 때문에 어쩔 수 없다...
        dp[2] = 1;
        for (int i = 4; i <= N; i+=2) {
            for (int j = 0; j <= i-2; j+=2) {
//                System.out.println("dp["+i+"] += "+"dp["+j+"]"+"+"+"dp["+i+"-"+j+"]");
                dp[i] += dp[j] * dp[i-j-2]; // dp[2~i-2] * dp[i-2~2]
                dp[i] %= 987654321; // 더하고 나눠야함
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
