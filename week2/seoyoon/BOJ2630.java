package week2.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int wCnt, bCnt, N;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        wCnt = 0;
        bCnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
               paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cuttingPaper(0,0, N);
        System.out.println(wCnt+"\n"+bCnt);
    }

    public static void cuttingPaper(int y, int x, int N) {
        if (checkColor(y, x, N) == true) {
            if (paper[y][x] == 0) wCnt++;
            else bCnt++;
            return;
        }

        cuttingPaper(y, x, N/2);
        cuttingPaper(y + N/2, x, N/2);
        cuttingPaper(y, x + N/2, N/2);
        cuttingPaper(y + N/2, x + N/2, N/2);
    }

    public static boolean checkColor(int y, int x, int N) {
        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                if (paper[y][x] != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
