package programmers.heap;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PRO_이중우선순위큐 {
		public static void main(String[] args) {
//			String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
			String[] operations = new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
			solution(operations);
		}
	    public static int[] solution(String[] operations) {
	        int[] answer = {};
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>();   // 오름차순
	        PriorityQueue<Integer> tempPQ = new PriorityQueue<>();
	        for(String operation : operations){
	        	 tempPQ = new PriorityQueue<>();
	            //Split
	            StringTokenizer st = new StringTokenizer(operation);
	            String oper = st.nextToken();
	            int num = Integer.parseInt(st.nextToken());
	            
	            if(oper.equals("I")){
	                //INSERT
	                pq.add(num);
	            }else if(oper.equals("D")){
	                if(num == -1){
	                    // DELETE MIN VALUE
	                    if(pq.isEmpty()){
	                        continue;
	                    }else if(pq.size() == 1){
	                    	pq.poll();
	                    }else{
	                        //2개 이상
	                        int size = pq.size();
	                        for(int i=0; i<size; i++){
	                            if(i == 0){
	                                pq.poll();
	                                continue;
	                            }

	                            tempPQ.add(pq.poll());
	                        }
	                        pq = tempPQ;
	                    }
	                }else{
	                    // DELETE MAX VALUE
	                    if(pq.isEmpty()){
	                        continue;
	                    }else if(pq.size() == 1){
	                    	pq.poll();
	                    }else{
	                        //2개 이상
	                        int size = pq.size();
	                        for(int i=0; i<size; i++){
	                            if(i == size-1){
	                                break;
	                            }

	                            tempPQ.add(pq.poll());
	                        }
	                        pq = tempPQ;
	                    }
	                } 
	            }
	            
	        }// 모든 연산 끝
	        if(pq.isEmpty()){
	            answer = new int[]{0,0};
	        }else {
	        	// 비어있지 않다면
	        	int max = 0;
	        	int min = 0;
	        	
	        	if(pq.size() == 1) {
	        		max = pq.peek();
	        		min = pq.peek();
	        	}else {
		        	int size = pq.size();
		        	for(int i=0; i<size; i++) {
		        		if(i == 0 ) {
		        			min = pq.peek();
		        		}
		        		if(i == size - 1) {
		        			max = pq.peek();
		        			continue;
		        		}
		        		
		        		pq.poll();
		        	}
	        	}
	        	answer = new int[] {0, 0};
	        	
	        	answer[0] = max;
	        	answer[1] = min;
	        }
	        return answer;
	    }
}
