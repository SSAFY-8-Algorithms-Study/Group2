package trying;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PROG_힙_level3_이중우선순위큐 {
	public static void main(String[] args) {
		
//		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		// expect 0, 0
		
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		// expect 333, -45
		
		Solution(operations);
	}
	
	static void Solution(String[] operations) {
		
		PriorityQueue<Info> minQ = new PriorityQueue<>((a,b) -> a.v >= b.v ? 1 : -1); // 최소값이 앞에 오는 큐
		PriorityQueue<Info> maxQ = new PriorityQueue<>((a,b) -> b.v >= a.v ? 1 : -1); // 최대값이 앞에 오는 큐
		int[] status = new int[1_000_000]; // 최대 operations 길이까지의 상태 저장

		for (int i = 0; i < operations.length; i++) { // operations 길이 만큼
			String[] operation = operations[i].split(" ");
			String cmd = operation[0];
			int n = Integer.parseInt(operation[1]);
			
			if(cmd.equals("I")) {
				minQ.add(new Info(n,i)); // 양쪽에 저장, statusIdx에 i(operation위치) 저장
				maxQ.add(new Info(n,i));
				status[i]++; // 상태 ++ 표시
			}
			else {
				if(n==1) { // 최댓값 삭제
					while(true) {
						if(maxQ.isEmpty()) break;
						Info info = maxQ.poll();
						if(status[info.statusIdx] > 0) { // 삭제 되었는지 확인
							status[info.statusIdx]--; // 상태 --;
							break;
						}
					}
				}
				else { // 최솟값 삭제
					while(true) {
						if(minQ.isEmpty()) break;
						Info info = minQ.poll();
						if(status[info.statusIdx] > 0) {
							status[info.statusIdx]--;
							break;
						}
					}
				}
			}
		}

		int max = 0;
		int min = 0;
		
		while(true) {
			if(maxQ.isEmpty()) break;
			Info maxInfo = maxQ.poll();
			if(status[maxInfo.statusIdx] > 0) { // 상태 확인
				max = maxInfo.v; // 최댓값 갱신
				break;
			}
		}
		while(true) {
			if(minQ.isEmpty()) break;
			Info minInfo = minQ.poll();
			if(status[minInfo.statusIdx] > 0) {
				min = minInfo.v;
				break;
			}
		}
		System.out.print(max + ","+ min);
	}
	
	static class Info {
		int v, statusIdx;
		Info(int v, int statusIdx) {
			this.v = v;
			this.statusIdx = statusIdx;
		}
	}
}