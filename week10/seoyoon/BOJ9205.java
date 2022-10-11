package week10.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ9205:맥주 마시면서 걸어가기 */
public class BOJ9205 {
    static class Point {
        int y, x;
        boolean visit;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static Point[] store;
    static Point home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine());

            // 상근이 집
            StringTokenizer st = new StringTokenizer(br.readLine());
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 편의점
            store = new Point[n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // 페스티벌
            st = new StringTokenizer(br.readLine());
            store[n] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // End Input

            bfs();
        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<Point>();
        q.add(home);
        home.visit = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.y == store[n].y && cur.x == store[n].x) {
                System.out.println("happy");
                return;
            }

            for (int i = 0; i <= n; i++) {
                if (!store[i].visit && distance(store[i].y, store[i].x, cur.y, cur.x) <= 1000) {
                    store[i].visit = true;
                    q.add(new Point(store[i].y, store[i].x));
                }
            }
        }
        System.out.println("sad");
    }

    static double distance(int y1, int x1, int y2, int x2) {
        return Math.abs(y2 - y1) + Math.abs(x2 - x1);
    }
}
