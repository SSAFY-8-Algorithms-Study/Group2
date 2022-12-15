package programmers.stack;

import java.util.Stack;

public class 올바른괄호 {
	public static void main(String[] args) {
		String s = "(()(";
		System.out.println(solution(s));
	}
	static boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        char[] charArr = s.toCharArray();
        if(charArr[0] == ')'){
            return false;
        }else{
            //stack 사용 검사
            Stack<Character> stack = new Stack<>();
            
            // (면 삽입 )면 꺼내서 확인 후 삭제
            for(char c : charArr){
                if(c == '('){
                    stack.push(c);
                }else{
                    // )면 꺼내서 확인
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        if(stack.peek() == ')'){
                            return false;
                        }else {
                        	stack.pop();
                        }
                    }
                }
            } // end for
            // for 문 끝났을 때 stack 안 비워져 있으면 false;
            if(!stack.isEmpty()) {
            	return false;
            }
        }
        return answer;
    }
}
