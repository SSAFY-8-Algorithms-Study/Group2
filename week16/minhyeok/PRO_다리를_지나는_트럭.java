import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int curTime = 1; // 현재 시간 
        int onBridgeWeight = 0; // 다리 위의 무게 합
        ArrayDeque<int[]> onBridge = new ArrayDeque<int[]>(); // 다리 위 (트럭의 무게i, 트럭이 다리를 벗어나는 시간)
        
        int truckSize = truck_weights.length; // 트럭의 개수 
        // 대기 트럭 -> 다리
        for (int i=0; i<truckSize; i++) {
            // 기다리는 트럭 
            int tw = truck_weights[i];
            
            // 트럭이 다리에 올라갈 수 없으면 트럭이 나갈 때까지 기다려야 한다
            while (onBridgeWeight + tw > weight) {
                int[] truck = onBridge.poll();
                onBridgeWeight -= truck[0];
                curTime = Math.max(curTime,truck[1]); // 트럭이 완전히 다리 밖으로 나가는 시간
            }
            
            // 트럭이 다리로 올라간다.
            onBridgeWeight += tw;
            onBridge.add(new int[]{tw, curTime+bridge_length}); // 트럭 i의 무게,    트럭 i가 완전히 다리 밖으로 나가는 시간)
            curTime++;
        }
        // 트럭이 최종적으로 다리를 빠져나가는 순간 체크
        while(!onBridge.isEmpty()) {
            int[] truck = onBridge.poll();
            answer = truck[1];
        }
        
        return answer;
    }
}