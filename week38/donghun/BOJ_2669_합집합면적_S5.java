package week38.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669_합집합면적_S5 {

    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new boolean[100][100];

        for (int line = 0; line < 4; line++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            int endx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());

            for (int i = startx; i < endx; i++) {
                for (int j = starty; j < endy; j++) {
                    if (!map[i][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i<100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]) count++;
            }
        }

        System.out.println(count);
    }
}
