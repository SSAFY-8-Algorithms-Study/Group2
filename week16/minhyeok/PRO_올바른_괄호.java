class Solution {
    // 전역 변수 선언 - 스택, 크기 
    char[] stack = new char[100_000];
    int size = 0;
    
    // 전역 메서드 - push, pop
    void push(char c) { 
        // 배열의 맨 뒤로 추가 
        this.stack[this.size++] = c; 
    }
    
    char pop() { 
        // 배열의 맨 뒤 꺼내기
        return this.stack[--this.size];
    }
    
    boolean solution(String s) {
        boolean answer = true;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 문자가 ( 이면 스택에 추가 그렇지 않으면 꺼내기 
            if (c == '(') {
                this.push(c);
            } else {
                // ')'인 경우 스택이 비어있거나 꺼낸 문자가 ')'이면 false
                if (this.size == 0) return false;
                if (this.pop() == ')') return false;
            }
        }
        
        // 모두 실행한 뒤 스택의 크기가 0보다 크면 false
        if (this.size > 0) return false;
        return answer;
    }
}