import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * BOJ 11286 Silver 1
 * 절댓값 힙
 * 1. 인덱스인 [0]에 절대값을 넣고 [1]에 값을 넣은 배열을 큐에 삽입
 * 2. 절대값끼리 정렬
 */
public class BOJ11286 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 2. 절대값끼리 정렬
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				if(q.isEmpty()) sb.append(0 + "\n");
				else sb.append(q.poll()[1] + "\n");
			}
			// 1. 인덱스인 [0]에 절대값을 넣고 [1]에 값을 넣은 배열을 큐에 삽입
			else q.add(new int[] {Math.abs(num), num});
		}
		System.out.print(sb);
	}
}