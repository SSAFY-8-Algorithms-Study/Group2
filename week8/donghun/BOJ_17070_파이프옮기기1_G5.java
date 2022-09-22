package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
DP
7% 오답
*/
public class BOJ_17070_파이프옮기기1_G5 {
    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N][3]; // 0:가로, 1:대각선, 2:세로

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] != 1) {
                    if (i == 0) {
                        if(!flag) {
                            dp[i][j][0] = 1;
                            flag = true;
                        } else {
                            dp[i][j][0] = 0;
                        }
                    } else {

                        dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1]; // 시작점에 닿기까지의 방법들
                        if (map[i - 1][j] != 1 && map[i][j - 1] != 1) { //
                            dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                        }
                        dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2]; // 시작점에 닿기까지의 방법들
                    }
                }
            }
        }

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}
