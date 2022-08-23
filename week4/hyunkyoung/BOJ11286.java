package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 { // 절대값 힙
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 연산 개수
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}
		}); // 절대값 작은 순서 + 절대값 같은 경우 오름차순 정렬
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) { // 0인 값: 절대값이 가장 작은 값 출력 후 제거
				// 빈 배열인데 절대값 가장 작은 값 연산 시 0 출력
				if(pq.isEmpty()) sb.append(0);
				else {
					sb.append(pq.poll());
				}
				sb.append('\n');
			} else { // x가 0이 아닌 값: 배열에 x값 추가
				pq.add(num);
			}
		}
		
		System.out.println(sb);
	}
}
