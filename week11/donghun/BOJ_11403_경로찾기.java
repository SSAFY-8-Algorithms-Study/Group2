package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
    static int N;
    static int[][] map;
    static int[][] result;
    //    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go();

        print(result);

    }

    private static void go() {
        for (int i = 0; i < N; i++)
            bfs(i);
    }

    private static void bfs(int inputi) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        q.add(inputi);

        while (!q.isEmpty()) {
            int nowi = q.poll();
            for (int j = 0; j < N; j++) {
                if (map[nowi][j] == 1 && !visited[j]) {
                    q.add(j);
                    visited[j] = true;
                    result[inputi][j] = 1;
                }
            }
        }
    }

    private static void print(int[][] array) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
