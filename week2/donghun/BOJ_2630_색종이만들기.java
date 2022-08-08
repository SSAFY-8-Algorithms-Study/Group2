package donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
    static int white, blue;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0, N);

        System.out.println(white + "\n" + blue);
    }

    static void div(int row, int col, int size) {

        // 여길 통과하면 각 값 저장하고 종료
        if (oneColor(row, col, size)) {
            if (map[row][col] == 0)
                white++;
            else
                blue++;
            return;
        }

        int nextSize = size / 2;
        div(row, col, nextSize);
        div(row, col + nextSize, nextSize);
        div(row + nextSize, col, nextSize);
        div(row + nextSize, col + nextSize, nextSize);
    }

    static boolean oneColor(int row, int col, int size) {

        int color = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        // 모든 색상이 같다
        return true;
    }
}
