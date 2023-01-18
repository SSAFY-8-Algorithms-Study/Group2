class Solution {
    
    /*
        stack 자료구조처럼 가장 마지막의 숫자가 현재 숫자보다 작으면 k범위 내에서 없애주는 방식
    */
    
    public String solution(String number, int k) {
        String answer = "";
        String[] strArr = number.split("");
        String[] ansArr = new String[number.length() - k];
        
        int idx = 0;
        for (String str : strArr) {
            while (k>0) { // k 범위 내에서 스택의 마지막 숫자와 비교하기
                if (idx > 0 && str.compareTo(ansArr[idx-1]) > 0) {
                    ansArr[--idx] = "0";
                    k--;
                } else {
                    break;
                }
            }
            
            if (idx >= ansArr.length) continue;
            
            ansArr[idx++] = str;
        }
        
        for (String ans : ansArr) {
            answer += ans;
        }
        
        return answer;
    }
}