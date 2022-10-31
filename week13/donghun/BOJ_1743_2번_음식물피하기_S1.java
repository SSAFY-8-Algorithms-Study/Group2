package group.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_2번_음식물피하기_S1 {
    static Queue<Point> q; // bfs용 큐 선언
    static int N, M, K, count; // 맵 rc, 쓰레기수, 갱신할 최대 쓰레기더미 크기
    static boolean[][] map; // 맵을 boolean으로
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        q = new ArrayDeque<>(); // bfs 큐 생성

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1; // 인덱스 0부터
            int c = Integer.parseInt(st.nextToken())-1; // 동일

            map[r][c] = true; // 쓰레기 있으면 true 처리
        }

        // 맵 돌면서
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) { // true==쓰레기 有 -> bfs ON
                    q.add(new Point(i, j));
                    bfs(i, j);
                }
            }
        }

        System.out.println(count); // 최대 더미 크기 출력
    }

    private static void bfs(int starti, int startj) {

        int big = 0; // 이번 쓰레기 더미 크기 저장할 변수
        while (!q.isEmpty()) {
            Point now = q.poll();
            int nowi = now.i;
            int nowj = now.j;
            for (int d = 0; d < 4; d++) {
                int nexti = nowi + di[d];
                int nextj = nowj + dj[d];
                if (inBoundary(nexti, nextj) && map[nexti][nextj]) {
                    big++; // 추가
                    q.add(new Point(nexti, nextj));
                    map[nexti][nextj] = false; // 더했으면 수거
                }
            }
        }
        count = Math.max(count, big); // 더 큰놈 갱신
    }

    private static boolean inBoundary(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }

    private static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
