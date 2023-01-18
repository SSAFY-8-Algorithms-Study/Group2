package trying;

import java.util.ArrayDeque;

/*
 * 재귀로 풀었더니 "테스트 9,10 런타임 에러 발생"으로 이유를 찾느라 엄청 오래 걸렸다.
 * 논리적 설계를 떠나서 재귀를 너무 많이 하면 런타임 에러가 발생한다고 한다. 6,000 ~ 7,000 (java)
 * (https://freecontent.manning.com/stack-safe-recursion-in-java/)
 */
public class PROG_탐욕법_leve2_큰수만들기_v2 {
	public static void main(String[] args) {
		String number = "4177252841"; int k = 4; // expect 775841
		
		System.out.print(Solution(number, k));
	}
	
	static Object Solution(String number, int k) {
		int len = number.length() - k; // 만들 수 있는 수의 길이
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<int[]> q = new ArrayDeque<>(); // 굳이 큐를 사용할 필요는 없지만 내가 편함
		q.add(new int[] {0,0}); // idx, pos
		
		queue:
		while(!q.isEmpty()) {
			int[] el = q.poll();
			int idx = el[0];
			int pos = el[1];
			
			if(pos == len) break; // 길이 충족하면 종료
			int max = 0;
	        int size = number.length()-(len-pos); // len 길이의 문자를 만들기 위해 검사하는 끝지점
			
			for (int i = idx; i <= size; i++) {
				int next = number.charAt(i) - '0';
                
				if(max < next) max = next; // 가장 큰 값 찾기
                
                if(next == 9) { // 가장 큰 값이 9라면
                    sb.append(9); // 9 추가
                    q.add(new int[] {i+1, pos+1});
                    continue queue; // 다음과 비교하지 않고 넘기기
                }
			}
			
			for (int i = idx; i <= size; i++) {
				if(max == number.charAt(i) - '0') { // 큰 값을 찾아
					sb.append(max); // 문자열 뒤에 추가
					q.add(new int[] {i+1, pos+1});
					continue queue;
				}
			}
		}
		
		return sb.toString();
	}
}