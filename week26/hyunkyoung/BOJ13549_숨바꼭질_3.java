import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549_숨바꼭질_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[100001];
        pq.add(new Point(N, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            visit[p.x] = true;

            if (p.x == K) {
                System.out.println(p.w);
                break;
            }

            if (p.x * 2 <= 100000 && !visit[p.x * 2]) {
                pq.add(new Point(p.x * 2, p.w));
            }

            if (p.x - 1 >= 0 && !visit[p.x - 1]) {
                pq.add(new Point(p.x - 1, p.w + 1));
            }

            if (p.x + 1 <= 100000 && !visit[p.x + 1]) {
                pq.add(new Point(p.x + 1, p.w + 1));
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x, w;

        Point(int x, int w) {
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Point p) {
            return this.w - p.w;
        }
    }
}
