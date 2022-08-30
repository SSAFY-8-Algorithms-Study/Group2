package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ17142 - 연구소3 */
public class BOJ17142 {
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static boolean[] selected;
    static boolean[][] visited;
    static Point[] result;

    static ArrayList<Point> virus;
    static int N, M, min;
    static final int INF = 999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        virus = new ArrayList<Point>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == '2') {
                    virus.add(new Point(i, j));     // virus의 위치 좌표를 list에 따로 저장
                }
            }
        }
        // End Input

        selected = new boolean[virus.size()];
        result = new Point[M];
        min = Integer.MAX_VALUE;

        comb(0, 0);
        if (min == INF) min = -1;     // 바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우엔 -1
        System.out.println(min);    // 모두 퍼뜨렸다면 최소 시간 출력
    }

    static void comb(int idx, int start) {		// 조합으로 활성 바이러스 뽑기
        if (idx == M) {
            int returnBFS = bfs(result);
            min = Math.min(min, returnBFS);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            result[idx] = virus.get(i);
            comb(idx + 1, i + 1);
        }
    }

    static int bfs(Point[] arr) {
        char[][] copy = deepCopy();
        visited = new boolean[N][N];

        if (isSpread(copy)) return 0;   // 처음부터 모든 칸에 바이러스가 있다면 종료

        Queue<Point> q = new LinkedList<Point>();
        for (int i = 0; i < arr.length; i++) {

            q.offer(new Point(arr[i].y, arr[i].x));
            visited[arr[i].y][arr[i].x] = true;
            copy[arr[i].y][arr[i].x] = '9';     // 디버깅을 위해 바이러스에 마킹

        }

        int timeCnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Point point = q.poll();

                for (int d = 0; d < 4; d++) {
                    int newY = point.y + dy[d];
                    int newX = point.x + dx[d];

                    if (newY < 0 || newY >= N || newX < 0 || newX >= N || visited[newY][newX] || copy[newY][newX] == '1') continue;

                    q.offer(new Point(newY, newX));
                    visited[newY][newX] = true;
                    copy[newY][newX] = '9';
                }
            } 	// end for size
            timeCnt++;

            if (isSpread(copy)) {       // 바이러스가 다 퍼졌다면 종료
                return timeCnt;
            }
        }	// end while
        return INF;     // 바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우
    }

    static boolean isSpread(char[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copy[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    static char[][] deepCopy() {
        char[][] copy = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
}
