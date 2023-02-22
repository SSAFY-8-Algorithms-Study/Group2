class Solution {
    
    /*
        이분 탐색으로 n명을 심사할 수 있는 최소 시간(m)을 구한다.
    */
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 최소 심사 시간 구하기
        long minTime = Integer.MAX_VALUE;
        for (int time : times) {
            if (time < minTime) {
                minTime = time;
            }
        }
        
        // 탐색할 범위의 양쪽 끝 값 구하기
        long l = 0;
        long r = n * minTime;
        
        // 이분 탐색
        while (l<=r) {
            long m = l + (r-l)/2;
            long checked = 0;
            for (int time : times) {
                checked += m/time;
            }
            
            if (checked >= n) {
                answer = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
        
        return answer;
    }
}