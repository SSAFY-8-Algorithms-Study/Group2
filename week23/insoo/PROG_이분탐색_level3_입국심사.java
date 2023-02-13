import java.util.PriorityQueue;
class PROG_이분탐색_level3_입국심사 {
	// 시간초과로 실패
    public long solution(int n, int[] times) {
		PriorityQueue<Info> pq = new PriorityQueue<Info>((a,b) -> a.time < b.time ? -1 : 1);
		
		for (int i = 0; i < times.length; i++) {
			pq.add(new Info(times[i], i));
		}

    	long nowTime = 0;
    	
		for (int i = 0; i < n; i++) {
			Info el = pq.poll();
			
			if(nowTime <= el.time) { // 사용하지 않는 요소 관리 떄문에 시간초과 발생
				nowTime = el.time;
				pq.add(new Info(nowTime + times[el.idx], el.idx));
			}
			else {
				pq.add(new Info(el.time + times[el.idx], el.idx));
			}
		}
		
		return nowTime;
	}
	
	static class Info {
		int idx;
		long time;
		Info(long time, int idx) {
			this.time = time;
			this.idx = idx;
		}
	}
}