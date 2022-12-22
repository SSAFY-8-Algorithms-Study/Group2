import java.util.Stack;

class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            
            if(chr == '(') { // 여는 괄호는 스택에 push
                stack.push('(');
            } else { // 닫는 괄호인 경우
                if(!stack.isEmpty()) { // 스택에 '('가 남아있을 경우
                    stack.pop(); // '(' pop
                } else { // 스택에 '('가 없는 경우
                    answer = false; // 괄호 쌍을 이룰 수 없으므로 false
                    break;
                }
            }
        }

        // 모든 괄호 탐색 후 스택이 비어있지 않다면 쌍을 이루지 못한 '('가 남아있으므로 false
        if(!stack.isEmpty()) answer = false;
        
        return answer;
    }
}
