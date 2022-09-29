package week8.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ 17070 : 파이프 옮기기 1 */
public class BOJ17070 {

    static int N, cnt;
    static int[][] map;
    static int[][] pipeHor = {{0, 1}, {1, 1}};          // -
    static int[][] pipeVer = {{1, 0}, {1, 1}};          // \
    static int[][] pipeDia = {{0, 1}, {1, 1}, {1, 0}};  // ㅣ

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        connectPipe();
        System.out.println(cnt);
    }

    public static void connectPipe() {
        ArrayList<Point> q = new ArrayList<>();
        q.add(new Point(1, 2, 'H'));

        while(!q.isEmpty()) {
            Point cur = q.remove(q.size() - 1);

            if (cur.y == N && cur.x == N) {
                cnt++;
            }

            switch(cur.type) {
                case 'H':
                    for (int i = 0; i < pipeHor.length; i++) {
                        int newY = cur.y + pipeHor[i][0];
                        int newX = cur.x + pipeHor[i][1];

                        if ((newY <= N && newX <= N && newX >= 1 && newY >= 1) && map[newY][newX] == 0) {
                            switch(i) {
                                case 0:
                                    q.add(new Point(newY, newX, 'H'));
                                    break;
                                case 1:
                                    if (map[cur.y + 1][cur.x] == 0 && map[cur.y][cur.x + 1] == 0) {
                                        q.add(new Point(newY, newX, 'D'));
                                    }
                                    break;
                            }
                        }
                    }
                    break;
                case 'V':
                    for (int i = 0; i < pipeVer.length; i++) {
                        int newY = cur.y + pipeVer[i][0];
                        int newX = cur.x + pipeVer[i][1];

                        if ((newY <= N && newX <= N && newX >= 1 && newY >= 1) && map[newY][newX] == 0) {
                            switch(i) {
                                case 0:
                                    q.add(new Point(newY, newX, 'V'));
                                    break;
                                case 1:
                                    if (map[cur.y + 1][cur.x] == 0 && map[cur.y][cur.x + 1] == 0) {
                                        q.add(new Point(newY, newX, 'D'));
                                    }
                                    break;
                            }
                        }
                    }
                    break;
                case 'D':
                    for (int i = 0; i < pipeDia.length; i++) {
                        int newY = cur.y + pipeDia[i][0];
                        int newX = cur.x + pipeDia[i][1];

                        if ((newY <= N && newX <= N && newX >= 1 && newY >= 1) && map[newY][newX] == 0) {
                            switch(i) {
                                case 0:
                                    q.add(new Point(newY, newX, 'H'));
                                    break;
                                case 1:
                                    if (map[cur.y + 1][cur.x] == 0 && map[cur.y][cur.x + 1] == 0) {
                                        q.add(new Point(newY, newX, 'D'));
                                    }
                                    break;
                                case 2:
                                    q.add(new Point(newY, newX, 'V'));
                                    break;
                            }
                        }
                    }
                break;
            }
        }
    }

    static class Point {
        int y, x;
        char type;

        public Point(int y, int x, char type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}
