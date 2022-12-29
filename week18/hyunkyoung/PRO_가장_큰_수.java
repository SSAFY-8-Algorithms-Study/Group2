import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int[][] numbers_set = new int[numbers.length][2];
        
        for(int i = 0; i < numbers.length; i++) {
            String str = Integer.toString(numbers[i]);
            numbers_set[i][0] = str.length();
            
            for(int j = 0; j < 4 - numbers_set[i][0]; j++) {
                str += String.valueOf(str.charAt(j));
            }
            
            numbers_set[i][1] = Integer.parseInt(str);
        }
        
        Arrays.sort(numbers_set, (o1, o2) -> o2[1] - o1[1]);
        
        for(int i = 0; i < numbers.length; i++) {
            String str = Integer.toString(numbers_set[i][1]).substring(0, numbers_set[i][0]);
            answer += str;
        }
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}