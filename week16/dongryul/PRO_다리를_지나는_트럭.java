package programmers.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		solution(0, 0, new int[]{1,2});
	}
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        bridge_length = 100;
        weight = 100;
        truck_weights = new int[]{10,10,10,10,10,10,10,10,10,10};
        
        int nowTime = 1;
        
        Queue<Truck> bridge = new LinkedList<>();
        int outCnt = 0;
        int total_weight = 0;
        int i = 0;
        while(true) {
        	if(!bridge.isEmpty()) {
        		//맨 맢 트럭 들어온 시간 비교
        		if(nowTime - bridge.peek().enterTime == bridge_length) {
        			Truck t = bridge.poll();
        			total_weight -= t.weight;
        			outCnt++;	//나간 갯수 증가
        			
        			if(outCnt == truck_weights.length) break;	// 다 나갔으면 중지.
        		}
        	}
        	
        	if(i < truck_weights.length && total_weight + truck_weights[i] <= weight) {
        		//현재 총 트럭 무게 + 다음 트럭 무게 <= 올라갈 수 있는 무게
        		bridge.add(new Truck(nowTime, truck_weights[i]));
        		total_weight += truck_weights[i];	// 다리에 올라간 트럭 무게
        		i++;	//다음거 봐야지.
        	}
        	nowTime++;	//시간 증가
        }
        System.out.println(nowTime);
        return nowTime;
    }
    static class Truck{
    	int enterTime;
    	int weight;
		public Truck(int enterTime, int weight) {
			super();
			this.enterTime = enterTime;
			this.weight = weight;
		}
    	
    	
    }
}
