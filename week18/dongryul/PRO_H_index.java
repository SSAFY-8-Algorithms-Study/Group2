package programmers.sort;

import java.util.Arrays;

public class PRO_H_index {	
	public int solution(int[] citations) {
        int answer = 0;
        int[] count = new int[10001];   //인용 횟수
        Integer[] arr = new Integer[citations.length];
        
        for(int i=0; i<citations.length; i++){
            arr[i] = citations[i];
        }
        
        Arrays.sort(arr, (n1, n2)->n2-n1);
        for(int c : arr){
            count[c]++;
        }
        
        int start = arr[0];   //최댓값
        int up = count[start];
        int down = up;  // 자기 자신 포함
        
        for(int i = start-1; i>=0; i--){
        	
            if(count[i] != 0){
                down += count[i];
            }
        }
        
        //최댓값 부터 아래로 확인
        while(true){
            if(up >= start) break;   // 두개가 같으면 종료
            
            down -= count[start];
            start--;
            //아니면
            up += count[start];
        }
        answer = start;
        return answer;
    }
}
