import java.util.*;
class Solution {
    
    // 전역변수 큐 초기화 
    int[][] queue = new int[100][2]; // (index, priority)
    int size = 0;
    
    // 전역 메서드 push -  큐의 맨 뒤에 원소 추가 
    void push(int[] doc) {
        this.queue[this.size++] = doc;
    }
    
    // 전역 메서드 popFirst = 큐의 맨 앞의 원소 가져오기
    int[] popFirst() {
        int[] copy = new int[2];
        copy[0] = this.queue[0][0];
        copy[1] = this.queue[0][1];
        
        // 한 칸씩 앞으로 당기기
        for (int i=0; i<this.size-1; i++) {
            this.queue[i] = this.queue[i+1];
        }
        // 맨 뒤의 원소 null 값 처리 
        this.queue[--this.size] = null;
        
        return copy;
    }
    
    public int solution(int[] priorities, int location) {
        // 프린트 순서
        int answer = 0;
        
        // 큐 초기화 
        for (int i=0; i<100; i++) {
            this.queue[i] = null;
        }
        
        // 큐에 인덱스와 우선순위 넣기 
        for (int i=0; i<priorities.length; i++) {
            this.push(new int[]{i,priorities[i]});
        }
        
        // 우선순위를 고려해 문서 출력하기 
        while(this.size > 0) {
            int[] doc = this.popFirst();
            int idx = doc[0];
            int curP = doc[1];
            boolean isPrint = true;
            
            // 큐를 순회하면서 자신보다 큰 우선순위 찾아서 다시 뒤로 집어넣기
            for (int i=0; i<this.size; i++) {
                if (this.queue[i][1] > curP) {
                    this.push(doc);
                    isPrint = false;
                    break;
                }
            }
            
            if (!isPrint) continue;
            
            // 자신의 우선순위가 가장 크다면 프린트하기 (answer + 1)
            if (idx == location) return answer+1;
            answer++;
            
        }
        return answer;
    }
}