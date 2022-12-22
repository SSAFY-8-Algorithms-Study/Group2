package week17.seoyoon;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PRO_이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        StringTokenizer st = null;
        String ch = "";
        int num = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();   // 최소힙
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            ch = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            if (ch.equals("I")) {    // I = Insert
                pq.add(num);
            }
            else {      // D = Delete
                if (!pq.isEmpty()) {    // 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시
                    if (num == 1) {     // 최댓값 삭제
                        PriorityQueue<Integer> newPQ = new PriorityQueue<Integer>();
                        while (pq.size() > 1) {     // 최댓값만 빼놓고 새로운 PQ에 옮기기
                            newPQ.add(pq.poll());
                        }
                        pq = newPQ;
                    }
                    else {
                        pq.poll();      // 최솟값 삭제
                    }
                }
            }
        }

        if (!pq.isEmpty()) {
            answer[1] = pq.poll();      // 최솟값
            while (pq.size() > 1) {     // 중간은 다 빼
                pq.poll();
            }
            answer[0] = pq.poll();      // 최댓값
        }
        return answer;
    }
}
