package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week10_2번 {
    static Point start, end;
    static Point[] depots;
    static boolean[] visited;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            depots = new Point[n + 2];
            visited = new boolean[n + 2];

            // 집
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                start = new Point(a, b);
                depots[0] = start;
            }

            // 편의점
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                depots[i] = new Point(a, b);
            }

            // 목적지
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                end = (new Point(a, b));
                depots[n + 1] = end;
            }
            // input end

            list = new ArrayList[depots.length];

            for (int i = 0; i < depots.length; i++) {
                list[i] = new ArrayList<Integer>();
            }

            // 연결 그래프
            for (int i = 0; i < depots.length; i++) {
                for (int j = 0; j < i; j++)
                    if (manhattan(depots[i], depots[j])) {
                        list[i].add(j);
                        list[j].add(i);
                    }
            }

//            System.out.println();

//            if (tc==13) {
//                for (int i = 0; i < list.length; i++) {
//                    System.out.print(i + ": ");
//                    for (int j = 0; j < list[i].size(); j++) {
//                        System.out.print("[" + (list[i].get(j)) + "], ");
//                    }
//                    System.out.println();
//                }
//            }

//            if (tc==13) sb.append("=\n");
            bfs();
//            if (tc==13) sb.append("=\n");

        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        int size0 = list[0].size();
        for (int i = 0; i < size0; i++) {
            q.add(list[0].get(i));
        }
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                visited[now] = true;

                if (now == n + 1) {
                    sb.append("happy\n");
                    return;
                }

                int size2 = list[now].size();
                for (int s2 = 0; s2 < size2; s2++) {

                    int next = list[now].get(s2);

                    if (next == n + 1) {
                        sb.append("happy\n");
                        return;
                    }

                    if (next < 1 || next > n + 1)
                        continue;

                    if (!visited[next]) {
                        q.add(next);
                    }
                }
            }
        }
        sb.append("sad\n");
    }

    static boolean manhattan(Point p1, Point p2) {
        return Math.abs(p1.i - p2.i) + Math.abs(p1.j - p2.j) <= 1000;
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
