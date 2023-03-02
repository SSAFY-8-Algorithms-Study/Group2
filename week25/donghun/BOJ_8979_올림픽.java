package group.week_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Point> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            pq.offer(new Point(idx, gold, silver, bronze));
        }

        int rank = 1;

        // 1등
        Point head = pq.poll();
        if (head.idx == K) {
            System.out.println(rank);
            return;
        }

        // 2등+@
        int dup = 1; // 안겹침 기준 최소 등수 +1
        int t=0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (head.gold == p.gold && head.silver == p.silver && head.bronze == p.bronze) { // 같은값
                dup++; // 겹쳤대요
            } else {
                head = p; // 비교군 갱신
                if (dup > 0) { // 겹친게 있었으면
                    rank += dup; // 그만큼 더해줘
                    dup = 1; // 초기화
                }
            }
            if (p.idx == K) { // 같은 놈이면
                System.out.println(rank); // 출력 후
                return; // 종료
            }

        }

    }

    static class Point implements Comparable<Point> {
        int idx;
        int gold;
        int silver;
        int bronze;

        public Point(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Point o) {
            if (o.gold == this.gold) {
                if (o.silver == this.silver) {
                    return o.bronze - this.bronze;
                } else return o.silver - this.silver;
            } else return o.gold - this.gold;
        }
    }
}
