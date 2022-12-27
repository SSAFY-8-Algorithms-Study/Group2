package temp_pro.week17;

import java.io.IOException;
import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        // TC
        int[] scovile = {1, 2, 3, 9, 10, 12};
        int K = 7;

        // 출력
        System.out.println(solution(scovile, K));
    }

    // K = 원하는 충족 스코빌 지수
    public static int solution(int[] scoville, int K) {
        int turn = 0; // 섞는 횟수

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 작은 숫자 우선순위 큐
        for (int j : scoville) pq.add(j); // 배열 -> 우선순위큐 값 주입

        while (true) {
            int _1 = pq.poll(); // 제일 작은 값 = _1

            if (_1 >= K) return turn; // 뽑은게 기준치보다 같거나 매우면 turn을 들고 종료
            if (pq.size() == 0) return -1; // pq 다뽑을때까지 >=K 안됐으면 -1 들고 종료

            int _2 = pq.poll(); // 두 번째로 매운 수치
            int next = _1 + _2 * 2; // 섞음

            if (next == 0) return -1; // 섞었더니 0이면 상승이 불가능하니 -1 들고 종료

            pq.add(next); // 0이 아니라면 등록

            turn++; // 섞는 횟수 증가
        }
    }
}
