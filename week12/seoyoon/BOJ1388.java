package week12.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ1388:바닥 장식 */
public class BOJ1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        // End Input

        // '-' Count
        int horCnt = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '-') {
                    flag = true;
                }
                // 다른 무늬가 나타났거나, 한 줄의 끝에 도착했다면 나무판자 count + 1
                if (map[i][j] == '|' || j + 1 == M) {
                    if (flag) horCnt ++;

                    flag = false;
                }
            }
        }

        // '|' Count
        int verCnt = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if (map[j][i] == '|') {
                    flag = true;
                }
                if (map[j][i] == '-' || j + 1 == N) {
                    if (flag) verCnt ++;

                    flag = false;
                }
            }
        }
        System.out.println(horCnt + verCnt);
    }
}
