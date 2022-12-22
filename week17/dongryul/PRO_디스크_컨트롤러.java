package programmers.heap;

import java.util.PriorityQueue;

public class PRO_디스크_컨트롤러 {
	public static void main(String[] args) {
		
		solution(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}} );
	}
	    public static int solution(int[][] jobs) {
	        int answer = 0;
	        
	        int beforeEnd = 0;  // 전의 작업 끝난 시간
	        
	        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) ->j1.latency - j2.latency);
	        
	        for(int[] job : jobs){
	            //job[0] = start, job[1] = during
	            Job j = new Job();
	            j.start = job[0];
	            j.during = job[1];
	            j.latency = (job[0] - beforeEnd) + job[1];
	            j.end = job[0] + job[1];
	            pq.add(j);
	        }
	        int count = pq.size();
	        int sum = 0;
	        while(!pq.isEmpty()){
	            // 맨 처음 작업 끝내기
	            Job j = pq.poll();
                System.out.println(j);
	            sum += j.latency;
	            
	            //끝나는 시점 Update
	            beforeEnd = j.end;
	            
	            PriorityQueue<Job> tempPQ = new PriorityQueue<>((j1, j2) ->j1.latency - j2.latency);
	            int size = pq.size();
	            
	            for(int s=0; s<size; s++){
	                Job next = pq.poll();   // 다음 것들 중 최소 구하기
	                System.out.println("next : " + next);
	                if(beforeEnd >= next.start){ // 대기하고 있다면
	                    // 기다리고 있던 시간 + during
	                	
	                    next.latency = beforeEnd - next.start + next.during;
//	                    next.start = beforeEnd;
	                    next.end = beforeEnd + next.during;
	                    
	                    
	                }else{
	                    // 안 기다리고 있다면 (끝나는 시간 이후)
	                    next.latency = next.start - beforeEnd + next.during;
	                    next.end = next.start + next.during;
	                }
	                tempPQ.add(next);
	            }
	            pq = tempPQ;
	            
	        }
	        answer = sum / count;
	        System.out.println(answer);
	        return answer;
	    }
	    static class Job{
	        int start;
	        int end;
	        int during;
	        int latency;
			@Override
			public String toString() {
				return "Job [start=" + start + ", end=" + end + ", during=" + during + ", latency=" + latency + "]";
			}
	        
	    }
}
