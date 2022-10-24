package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 실패 조건은 불을 피해 이동할 곳이 없거나, 출구가 막혔을 경우
 * 1. 불을 피해 이동할 곳이 없는 경우는 exit Queue 내의 Point에 도달하기 전 queue size가 0이 되었을 경우
 * 2. 출구가 없거나, 출구가 불타버려(poll) exit Queue의 size가 0이 되었을 경우
 */
public class week12_3번_BOJ_5427_불 {
    static int R, C;
    static char[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static Point start;
    static HashSet<String> exit;
    static Queue<Point> fire;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            exit = new HashSet<>();
            fire = new ArrayDeque<>();

            boolean flag = false;
            for (int i = 0; i < R; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    char temp = c[j];
                    map[i][j] = temp;
                    // 출구 Queue에 등록. 불 번질때마다 뺄것이고 bfs 도중 size 0이 되면 IMPOSSIBLE 출력 후 종료
                    if ((isExit(i, j)) && temp == '.') {
                        exit.add(i + "x" + j);
//                        System.out.println(exit);
                    }
                    // start 지점 (상근이 초기위치) 등록
                    if (temp == '@') {
                        start = new Point(i, j);
                    }
                    // start 개체가 이미 출구에 있었을 경우
                    if ((isExit(i, j)) && temp == '@') {
                        sb.append("1\n");
                        flag = true;
                    }
                    // 화점 등록
                    if (temp == '*') {
                        fire.add(new Point(i, j));
                    }
                }
            }
            if (flag) continue;

            // 처음부터 출구가 없었을 경우
            if (exit.size() == 0) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }

            bfs(start);

        }
        System.out.println(sb);
    }

    private static void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);

        int turn = 1;

        outer:
        while (true) {
            turn++;
            int fireSize = fire.size();
            for (int s = 0; s < fireSize; s++) {
                Point f = fire.poll();
                int fi = f.i;
                int fj = f.j;
                for (int d = 0; d < 4; d++) {
                    int nexti = fi + di[d];
                    int nextj = fj + dj[d];
                    if (inBoundary(nexti, nextj)) {
                        if (map[nexti][nextj] == '.') {
                            fire.add(new Point(nexti, nextj));
                            map[nexti][nextj] = '*';
                            // 출구가 불탔으면 set에서 삭제
                            if (isExit(nexti, nextj)) {
                                exit.remove(nexti + "x" + nextj);
                            }
                        }
                    }
                }
            }
            // 불탔는지 exit check
            if (exit.size() == 0) {
                sb.append("IMPOSSIBLE\n");
                break;
            }

//            print();

            int qSize = q.size();
            for (int s = 0; s < qSize; s++) {
                Point p = q.poll();
                int nowi = p.i;
                int nowj = p.j;
                for (int d = 0; d < 4; d++) {
                    int nexti = nowi + di[d];
                    int nextj = nowj + dj[d];
                    if (inBoundary(nexti, nextj)) {
                        // 통행 가능한 방이
                        if (map[nexti][nextj] == '.') {
                            // 출구면 탈출
                            if (isExit(nexti, nextj)) {
                                sb.append(turn).append("\n");
                                break outer;
                            }
                            // 출구가 아니면 bfs 계속
                            q.add(new Point(nexti, nextj));
                            map[nexti][nextj] = '@';
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                sb.append("IMPOSSIBLE\n");
                break;
            }
        }
    }

    private static void print() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
        ;
    }

    private static boolean isExit(int i, int j) {
        return i == 0 || j == 0 || i == R - 1 || j == C - 1;
    }

    private static boolean inBoundary(int i, int j) {
        return i >= 0 && i < R && j >= 0 && j < C;
    }

    private static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
