package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16918 {

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int R, C, N;
    static int[][] map;
    static ArrayList<Point> bombList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                map[i][j] = (c == '.') ? 0 : 1;
            }
        }

        int time = 2;
        while (time <= N) {
            bombList = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j]++;

                    if (time % 2 == 1) {
                        if (map[i][j] >= 3) {
                            map[i][j] = 0;
                            bombList.add(new Point(i, j));
                        }
                    }
                }
            }
            explode(bombList);
            time++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print((map[i][j] == 0) ? '.' : 'O');
            }
            System.out.println();
        }
    }

    static void explode(ArrayList<Point> bombList) {
        for (int i = 0; i < bombList.size(); i++) {
            int y = bombList.get(i).y;
            int x = bombList.get(i).x;

            for (int d = 0; d < 4; d++) {
                int newY = y + dy[d];
                int newX = x + dx[d];

                if (newY >= 0 && newY < R && newX >= 0 && newX < C) {
                    map[newY][newX] = 0;
                }
            }
        }
    }
}
