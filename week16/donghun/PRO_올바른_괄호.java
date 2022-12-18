import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean flag = true;
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') { // open
                stack.push(c);
            } else if ( c == ')') { // close 
                if (stack.size() == 0) { // 닫히는게 먼저오면
                    flag = false;
                    break;
                } else { // (이 있으면
                    stack.pop(); // 빼주고
                }
            }
    
        }
        
        if (stack.size() != 0) flag = false; // 안닫힌게 남아있으면 false

        return flag;
    }
}
