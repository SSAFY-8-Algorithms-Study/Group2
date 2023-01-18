import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        
        while(idx < number.length()) {
            char chr = number.charAt(idx);
            
            while(!stack.empty() && stack.peek() < chr) {
                if(stack.size() + k > idx) {
                    stack.pop();
                } else {
                    break;
                }
            }
            
            stack.push(chr);
            idx++;
        }
        
        while(!stack.empty()) {
            answer = stack.pop() + answer;
        }
        
        return answer.substring(0, number.length() - k);
    }
}