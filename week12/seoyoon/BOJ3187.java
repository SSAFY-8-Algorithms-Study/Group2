package week12.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ3187:양치기 꿍 */
public class BOJ3187 {
    static int R, C, vCnt, kCnt;	// vCnt: 늑대, kCnt: 양
    static char[][] map;
    static boolean[][] visit;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        // End Input

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(kCnt + " " + vCnt);
    }

    public static void bfs(int y, int x) {
        int v = 0, k = 0;

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {y, x});
        visit[y][x] = true;

        if (map[y][x] == 'v') v++;
        else if (map[y][x] == 'k') k++;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int newi = now[0] + di[d];
                int newj = now[1] + dj[d];

                if (newi < 0 || newi >= R || newj < 0 || newj >= C || map[newi][newj] == '#' || visit[newi][newj]) continue;

                visit[newi][newj] = true;
                if (map[newi][newj] == 'v') v++;
                else if (map[newi][newj] == 'k') k++;

                q.add(new int[] {newi, newj});
            }
        }
        if (k > v) kCnt += k;
        else vCnt += v;
    }
}
