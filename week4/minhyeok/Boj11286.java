package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj11286 {
	
	static int N;
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<int[]>(new Comparator<int[]>() { // 우선 순위 큐를 생성하고 정렬 조건을 추가해줍니다.

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) { // 0번째 값을 기준을 오름차순으로 정렬하되, 같은 값이면 1번째 값을 기준으로 오름차순 정렬합니다.
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			};
		
		});
		for (int i = 0; i < N ; i++) {
			int oper = Integer.parseInt(br.readLine());
			if (oper == 0) { // Operation
				if (pq.isEmpty()) { // 큐가 비었으면 0을 출력합니다.
					System.out.println(0);
				} else {
					int[] l = pq.poll();
					System.out.println(l[1]); // 원래 값 (1번쨰 값)을 출력합니다.
				}
			} else { // Not Operation, Put Number
				pq.add(new int[] {Math.abs(oper),oper}); // 배열의 0번째 원소로 들어온 값의 절댓값을 넣어주고 1번째 값으로 원래 값을 넣어줍니다.
			}
		}
	}
}
