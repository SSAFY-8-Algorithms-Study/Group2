import java.util.*;

class Solution {
    /*
        숫자를 내림차순 정렬하기
        [1234,123] -> 1231234
        [0,0] -> 0
    */
    
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        // 기준문자열숫자를 기준으로 내림차순 정렬 
        PriorityQueue<String[]> pq = new PriorityQueue<String[]>(
            (o1,o2) -> Integer.parseInt(o2[0]) - Integer.parseInt(o1[0])
        );
        
        for (int originalNum : numbers) {
            String strNum = originalNum + ""; // 기준문자열숫자
            int size = strNum.length();
            
            // 기준문자열숫자
            for (int i=0; i<4-size; i++) strNum += strNum;
            pq.add(new String[]{strNum.substring(0,4), originalNum+""});
        }
        
        int idx = 0;
        while(!pq.isEmpty()) {
            String[] strArr = pq.poll();
            if (strArr[1].equals("0") && idx == 0) return "0"; // [0,0] 악성 반례 피하기
            idx++;
            sb.append(strArr[1]);
        }
       
        return sb.toString();
    }
}