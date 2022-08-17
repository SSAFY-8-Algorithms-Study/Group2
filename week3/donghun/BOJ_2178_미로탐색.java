package week3.donghun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class room {
    int i;
    int j;

    public room(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class BOJ_2178_미로탐색 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N-1][M-1]);

    }

    static void bfs(int ni, int nj) {
        Queue<room> q = new LinkedList<room>();
        q.add(new room(ni, nj));
        while (!q.isEmpty()) {
            room r = q.poll();
            for (int d = 0; d < 4; d++) {
                int nexti = r.i + di[d];
                int nextj = r.j + dj[d];
                if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj] && map[nexti][nextj] == 1) {
                    q.add(new room(nexti, nextj));
                    map[nexti][nextj] = map[r.i][r.j] + 1;
                    visited[nexti][nextj] = true;
                }
            }
        }
    }
}
