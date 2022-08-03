package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = Math.min(N, M);
        int ans = 1;

        char[][] rect = new char[N][M];
        for (int i = 0; i < N; i++) {
            rect[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int k = 1; k < min; k++) {
                    if (i + k < N && j + k < M) {
                        if (rect[i][j] == rect[i + k][j] && rect[i][j] == rect[i][j + k] && rect[i][j] == rect[i + k][j + k]) {
                            ans = Math.max(ans, k + 1);
                        }
                    }
                }
            }
        }
        System.out.println(ans * ans);
    }
}
