import java.util.Queue;
import java.util.ArrayDeque;

class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_weight = 0; // 다리 위 트럭 총 무게
        int truck_number = 0; // 다리를 지나야 하는 트럭 순서
        Queue<Integer> queue = new ArrayDeque<>(); // 다리 큐
        
        for(int i = 0; i < bridge_length; i++) {
            queue.add(0); // 다리 길이만큼 큐에 0 넣기
        }
        
        while(!queue.isEmpty()) {
            answer++; // 시간 1 증가
            truck_weight -= queue.poll(); // 다리의 제일 앞 트럭이 다리를 건넘
            
            if(truck_number < truck_weights.length) { // 다리를 지나야 하는 트럭이 남은 경우
                if(truck_weight + truck_weights[truck_number] <= weight) { // 다리 위에 오를 수 있는 트럭인 경우
                    queue.add(truck_weights[truck_number]); // 큐에 트럭 무게 넣기
                    truck_weight += truck_weights[truck_number];
                    truck_number++;
                } else { // 다리 위에 오를 수 없는 트럭인 경우
                    queue.add(0); // 큐에 0 넣기
                }
            }
        }
        
        return answer;
    }
}
