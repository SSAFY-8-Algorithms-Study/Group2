package programmers.sort;

import java.util.Arrays;

public class PRO_K번째수 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int index=0;
        answer = new int[commands.length];
        for(int[] command : commands){
            // command[0] : i = start
            // command[1] : j = end
            // command[2] : k = k
            
            int[] tempArr = new int[command[1] - command[0] + 1];
            int arrayIndex = 0; //임시 배열 인덱스
            
            // start ~ end까지 뽑기
            for(int i=command[0] - 1; i<command[1]; i++){
                tempArr[arrayIndex++] = array[i];
            }
            //Sort
            Arrays.sort(tempArr);
            
            answer[index++] = tempArr[command[2]-1];
        }
        return answer;
    }
}
