import java.util.*;

class Solution {
    /*
        논문이 h번(citatiions[i]) 이상 인용된 논문이 h편(i+1) 이상이다.
    */
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,Collections.reverseOrder());
        
        int size = arr.length;
        int sum = 0;
        for (int i=0; i<size; i++) {
            if (arr[i] >= i+1) answer = i+1;
        }
        return answer;
    }
}