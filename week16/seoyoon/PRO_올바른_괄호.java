package week16.seoyoon;

import java.util.Stack;

public class PRO_올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(solution(")"));
    }

    private static boolean solution(String s) {
        boolean answer = true;
        Stack stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }

            else {							// ) 괄호가 들어온 경우
                if (!stack.isEmpty()) {		// stack이 비어있지 않다면? -> ( 괄호가 남아있음!
                    stack.pop();
                }
                else {						// stack이 비었다면? -> ( 괄호 없음!
                    answer = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {				// 문자열 s를 끝까지 봤는데 남은 (가 있다면? -> false
            answer = false;
        }

        return answer;
    }
}
