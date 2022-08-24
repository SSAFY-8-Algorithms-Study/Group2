package week4.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* BOJ2447 - 별찍기-10 */
public class BOJ2447 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');       // 배열을 우선 공백으로 만들어주기
        }
        drawStar(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void drawStar(int N, int startY, int startX) {
        if (N == 1) {                           // N == 1이 되면
            arr[startY][startX] = '*';          // 별 찍기
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                else drawStar(N / 3, startY + (N / 3) * i, startX + (N / 3) * j);
            }
        }
    }
}
