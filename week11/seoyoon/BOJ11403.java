package week11.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ11403:경로 찾기 */
public class BOJ11403 {
    static int N;
    static int[][] adjMatrix, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjMatrix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // End Input

        result = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adjMatrix[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int y, int x) {
        boolean[] visit = new boolean[N + 1];
        result[y][x] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= N; i++) {
                if (!visit[i] && adjMatrix[cur][i] == 1) {
                    result[cur][i] = 1;
                    visit[i] = true;
                    q.add(i);
                }
                if (visit[i]) {
                    result[y][i] = 1;
                }
            }
        }
    }
}
