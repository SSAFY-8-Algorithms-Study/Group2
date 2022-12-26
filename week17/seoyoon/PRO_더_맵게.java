package week17.seoyoon;

import java.util.PriorityQueue;

public class PRO_더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int sco : scoville) {
            pq.add(sco);
        }

        while (!pq.isEmpty()) {
            int minScoville = pq.poll();
            if (minScoville >= K) return answer;
            else if (!pq.isEmpty()) pq.add(minScoville + (pq.poll() * 2));
            answer++;
        }

        return -1;
    }
}
