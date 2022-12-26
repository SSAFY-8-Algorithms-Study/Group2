import java.util.*;
/**
    최소힙과 최대힙 에 모두 삽입한다.
    최솟값 or 최댓값 제거 시
        if minHeap의 루트값 == maxHeap의 루트값 -> 동시 제거
        else 따로 제거    
        if (minHeap 루트값 > maxHeap 루트값) 큐 초기화
**/
class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        // minHeap과 maxHeap 구현
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1,o2)->o1-o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1,o2)->o2-o1);
        
        for (String operation : operations) {
            String[] strArr = operation.split(" ");
            
            // INSERT
            if (strArr[0].equals("I")) {
                minHeap.add(Integer.parseInt(strArr[1]));
                maxHeap.add(Integer.parseInt(strArr[1]));
            }
            
            // DELETE
            if (strArr[0].equals("D")) {
                if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() == maxHeap.peek()) {
                    minHeap.poll();
                    maxHeap.poll();
                } else {
                    if (strArr[1].equals("1")) {
                        if (!maxHeap.isEmpty()) maxHeap.poll();
                    } else {
                        if (!minHeap.isEmpty()) minHeap.poll();
                    }
                }
                
                // RESET
                if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
                    minHeap = new PriorityQueue<Integer>((o1,o2)->o1-o2);
                    maxHeap = new PriorityQueue<Integer>((o1,o2)->o2-o1);
                }
            }
        }
        
        // MAX, MIN 값 구하기
        int min = 0;
        int max = 0;
        if (!minHeap.isEmpty()) min = minHeap.poll();
        if (!maxHeap.isEmpty()) max = maxHeap.poll();
        
        answer = new int[]{max,min};
        
        return answer;
    }
}