package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};

    static int[][] arr;
    static boolean[][] visited;
    static int N, M;

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }

    public static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.y][node.x] = true;

            for (int d = 0; d < 4; d++) {
                int newY = node.y + dy[d];
                int newX = node.x + dx[d];

                if (newY >= 0 && newY < N && newX >= 0 && newX < M && arr[newY][newX] == 1 && !visited[newY][newX]) {
                    q.offer(new Node(newY, newX));
                    arr[newY][newX] = arr[node.y][node.x] + 1;
                }

                if (visited[N - 1][M - 1]) {
                    System.out.println(arr[N - 1][M - 1]);
                    return;
                }
            }
        }
    }
}
