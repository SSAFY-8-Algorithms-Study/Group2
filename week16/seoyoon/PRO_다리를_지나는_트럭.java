package week16.seoyoon;

import java.util.ArrayDeque;
import java.util.Queue;

public class PRO_다리를_지나는_트럭 {
    public static void main(String[] args) {
        int[] arr = {7,4,5,6};
        System.out.println(solution(2, 10, arr));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int secCnt = 1;			// 경과 시간
        int curTruckIdx = 0;	// truck_weights[] 배열에서의 다리에 들어갈 트럭 인덱스
        int outTruckCnt = 0;	// 빠져나간 트럭 수 count

        Queue<Truck> q = new ArrayDeque<Truck>();
        q.add(new Truck(truck_weights[curTruckIdx], bridge_length));	// 첫번째 트럭 다리로 출발~
        int truckCnt = 1;		// 현재 다리 위에 있는 트럭 수
        int restWeight = weight - truck_weights[curTruckIdx++];			// 다리가 견딜 수 있는 남은 무게

        while (true) {
            q.forEach((truck) -> truck.restDist--);		// 다리에 올라가있는 모든 트럭의 남은 거리 -1
            secCnt++;									// 경과시간 +1

            if (q.peek().restDist == 0) {				// 제일 앞에있는 트럭의 남은 거리가 0이라면 빠져나가기
                truckCnt--;								// 빠져나간 트럭만큼 원상복구
                outTruckCnt++;
                restWeight += q.peek().weight;
                q.poll();
            }

            if (outTruckCnt == truck_weights.length) {	// 빠져나간 트럭의 수 = 전체 트럭의 수 => 종료
                break;
            }

            if (curTruckIdx < truck_weights.length) {	// truck 배열의 범위를 벗어나지 않고
                if (truckCnt < bridge_length && restWeight - truck_weights[curTruckIdx] >= 0) {		// 현재 다리에 올라간 트럭의 수가 bridge_length보다 작으면서 + 다리에 올라갈 새로운 트럭의 무게를 다리가 견딜 수 있다면
                    q.add(new Truck(truck_weights[curTruckIdx], bridge_length));					// 다리에 올려주기

                    restWeight -= truck_weights[curTruckIdx];
                    truckCnt++;
                    curTruckIdx++;
                }
            }
        }

        return secCnt;
    }

    private static class Truck {
        int weight;		// 트럭의 무게
        int restDist;	// 다리를 통과하기 위해 남은 거리

        public Truck(int weight, int restDist) {
            this.weight = weight;
            this.restDist = restDist;
        }
    }
}
