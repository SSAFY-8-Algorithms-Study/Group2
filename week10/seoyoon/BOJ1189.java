package week10.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ1189:컴백홈 */
public class BOJ1189 {
    static int R, C, K, KCnt;
    static char[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.println(KCnt);
    }

    static void dfs(int y, int x, int cnt) {
        if (y == 0 && x == C - 1 && cnt == K) {
            KCnt++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int newY = y + dy[d];
            int newX = x + dx[d];

            if (newY >= 0 && newY < R && newX >= 0 && newX < C && map[newY][newX] != 'T' && !visited[newY][newX]) {
                visited[newY][newX] = true;
                dfs(newY, newX, cnt + 1);
                visited[newY][newX] = false;
            }
        }
    }
}
