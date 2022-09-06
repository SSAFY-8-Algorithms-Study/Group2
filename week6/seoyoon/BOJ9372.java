package week6.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9372 {
    static int[][] graph;
    static boolean[] visited;
    static int N, M, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                graph[a][b] = graph[b][a] = 1;
            }


            System.out.println(bfs());
        }
    }

    static int bfs() {
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            cnt++;

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[num][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return cnt - 1;
    }
}
