package temp_pro.week17;

import java.io.IOException;
import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] scovile = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scovile, K));
    }

    // K = 원하는 충족 스코빌 지수
    public static int solution(int[] scoville, int K) {
        int turn = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : scoville) pq.add(j);

        while (true) {
            int _1 = pq.poll();

            if (_1 >= K) return turn;
            if (pq.size() == 0) return -1;

            int _2 = pq.poll();
            int next = _1 + _2 * 2;

            if (next == 0) return -1;

            pq.add(next);

            turn++;
        }
    }
}
