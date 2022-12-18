import java.util.ArrayDeque;

public class PROG_스택큐_level2_다리를지나는트럭 {
	public static void main(String[] args) {
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10}; // return 110;
		
//		int bridge_length = 4;
//		int weight = 2;
//		int[] truck_weights = {1, 1, 1, 1}; // return 110;
		
		Solution();
	}
	
	static void Solution() {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6}; // return 8;
		/////////////////////////////////////////
		
		int idx = 0;
		int now_w = weight;
		int cnt = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>(); // 큐
		
		while(idx < truck_weights.length || !q.isEmpty()) {
			if(q.size()!=0 || idx == 0) cnt++;
			
			ArrayDeque<int[]> temp = new ArrayDeque<>();
			
			while(!q.isEmpty()) { // 큐에 있는 트럭들 앞으로 전진
				int[] el = q.poll();
				if(el[1] == bridge_length) {
					now_w += el[0]; // 다리 올라온 트럭 처리
					continue;
				}
				
				temp.add(new int[] {el[0], el[1]+1}); // 전진하고 temp 큐에 넣어주기
			}
			q = temp; // 큐 갱신
			
			// 다리에 새로운 트럭 추가
			if(idx < truck_weights.length && now_w - truck_weights[idx] >= 0) {
				now_w -= truck_weights[idx]; // 다리 건넌 트럭 처리
				q.add(new int[] {truck_weights[idx], 1});
				
				idx++;
			}
		}
		
		System.out.print(cnt);
	}
}