package donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
    static boolean[][] visited;
    static int[][] map;
    static int xStart, yStart, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[100][100];
        visited = new boolean[100][100];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            xStart = Integer.parseInt(st.nextToken());
            yStart = Integer.parseInt(st.nextToken());
            for (int i = xStart; i < xStart + 10; i++) {
                for (int j = yStart; j < yStart + 10; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
