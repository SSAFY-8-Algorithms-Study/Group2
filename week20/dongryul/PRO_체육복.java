package programmers.greedy;
class PRO_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] clothCnt = new int[n+1];
        
        for(int i=1; i<=n; i++){
            clothCnt[i] = 1;
        }
        // 여벌
        for(int i=0; i<reserve.length; i++){
            clothCnt[ reserve[i] ]++;
        }
        
        // 훔쳐감
        for(int i=0; i<lost.length; i++){
            clothCnt[ lost[i] ]--;
        }
        
        int lostIndex = 0;
        for(int i=1; i<=n; i++){
            if(clothCnt[i] != 0) continue;
            if(i == 1){
                // 다음 학생의 체육복이 2개면 빌려
                if(clothCnt[i + 1] == 2){
                    clothCnt[i + 1]--;
                    clothCnt[i]++;
                }
                continue;
            }
            if(i == n){
                // 전에 학생의 체육복이 2개면 빌려
                if(clothCnt[i - 1] == 2){
                    clothCnt[i - 1]--;
                    clothCnt[i]++;
                }
                continue;
            }
            if(clothCnt[i - 1] == 2){
                clothCnt[i - 1]--;
                clothCnt[i]++;
                
            }else if(clothCnt[i + 1] == 2){
                clothCnt[i + 1]--;
                clothCnt[i]++;
            }
        }
        for(int i=1; i<=n; i++){
            if(clothCnt[i] == 0) answer--;
        }
        
        return answer;
    }
}