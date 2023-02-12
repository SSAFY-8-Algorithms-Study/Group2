package programmers.binarySearch;

public class PRO_입국심사 {
	public long solution(int n, int[] times) {
        long answer = 0;
        
        // 최소 심사 시간 구하기
        long minTime = Integer.MAX_VALUE;
        for (int time : times) {
            if (time < minTime) {
                minTime = time;
            }
        }
        
        // max
        long R = minTime * n;
        long L = 0;
        
        while(L <= R){
            long M = (L + R) / 2;    // 중간 값
            
            long cnt = 0;
            for(int i=0; i<times.length; i++){
                cnt += M / times[i];
                
            }
            if(cnt >= n){
                answer = M;
                R = M - 1;
            }else if(cnt < n){
                L = M + 1;
            }
        }
        
        return answer;
    }
}
