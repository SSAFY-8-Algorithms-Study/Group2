package week13.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ1743:음식물 피하기 */
public class BOJ1743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N + 1][M + 1];
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        int max = 0;
        boolean[][] visit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                if(map[i][j] && !visit[i][j]) {    // 이 위치에 음식물이 있고 방문을 안했으면 BFS 시작!
                    int cnt = 1;

                    Queue<int[]> q = new ArrayDeque<int[]>();
                    q.add(new int[] {i, j});
                    visit[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int newi = cur[0] + delta[d][0];
                            int newj = cur[1] + delta[d][1];

                            if (newi < 1 || newi > N || newj < 1 || newj > M || !map[newi][newj] || visit[newi][newj]) continue;
                            cnt++;
                            q.add(new int[] {newi, newj});
                            visit[newi][newj] = true;
                        }
                    }
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }
}
