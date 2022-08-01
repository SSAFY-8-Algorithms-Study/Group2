package week1.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // start 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        // end 입력

        // start 로직
        int len = Math.min(N, M);
        while (len > 1) {
            for (int i = 0; i <= N - len; i++) {
                for (int j = 0; j <= M - len; j++) {
                    int num = arr[i][j];
                    if (num == arr[i][j + len - 1] && num == arr[i + len - 1][j]
                            && num == arr[i + len - 1][j + len - 1]) {
                        // 성공 출력
                        System.out.println(len * len);
                        return;
                    }
                }
            }
            len--;
        }
        // end 로직

        // 실패 출력
        System.out.println(1);
    }
}