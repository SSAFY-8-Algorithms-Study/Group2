import java.util.Arrays;

class Solution {
    /*
        자르고 정렬하기 !!
    */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int ansIdx = 0;
        
        for (int[] command : commands) {
            int[] temp = new int[command[1]-command[0]+1];
            
            int idx = 0;
            for (int i=command[0]-1; i<command[1]; i++) {
                temp[idx++] = array[i];
            }
            
            Arrays.sort(temp);
            answer[ansIdx++] = temp[command[2]-1];
            
        }
        return answer;
    }
}