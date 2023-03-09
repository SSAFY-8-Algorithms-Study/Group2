package week26.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ13549 {

    /**
     * Tier:
     * GOLD 5
     * Title: 숨바꼭질
     * Category: 그래프 이론, 그래프 탐색, 너비 우선 탐색, 테이크스트라, 0-1 너비 우선 탐색
     *
     * 순간이동, -1, +1 이동에 따라 동생을 찾을 수 있는 최단 시간을 구한다.
     * 최단 시간이기 때문에 순간 이동을 먼저 탐색 후 방문 처리한다.
     * 처음부터 수빈이와 동생의 위치가 똑같이 주어지는 케이스를 고려한다.
     *
     */

    public static class Info {
        int pos;
        int time;

        public Info(int pos, int time){
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int brother = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_000];
        int[] dir = {0,-1,1};
        ArrayDeque<Info> q = new ArrayDeque<Info>();
        q.add(new Info(subin,0));

        if (subin == brother) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            Info info = q.poll();
            int pos = info.pos;
            int time = info.time;

            for (int d : dir) {
                int next;
                int t = time;
                if (d == 0) {
                    next = pos * 2;
                } else {
                    next = pos + d;
                    t = time + 1;
                }

                if (next == brother) {
                    System.out.println(t);
                    return;
                }

                if (next >= 0 && next < 100000 && !visited[next]) {
                    visited[next] = true;
                    q.add(new Info(next,t));
                }
            }
        }
    }
}
