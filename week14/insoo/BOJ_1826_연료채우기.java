import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * BOJ 1826 Gold 2
 * 연료 채우기
 */
public class BOJ_1826_연료채우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 주유소 수

		Info[] arr = new Info[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Info(a, b);
		}
		
		Arrays.sort(arr,(i,j) -> i.a == j.a ? j.b - i.b : i.a - j.a); // 정렬
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // b 높은 순
		pq.add(0);
		
		int[] result = new int[L+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		
		int idxArr = 0;
		int idxRes = 0;
		int cnt = 0;

		while(!pq.isEmpty()) {
			P += pq.poll();
			
			if(idxArr < N) {
				while(P >= arr[idxArr].a) {
					pq.add(arr[idxArr++].b);
					if(idxArr == N) break;
				}
			}
			
			if(idxRes <= L) {
				while(idxRes <= P) {
					result[idxRes++] = cnt;
					if(idxRes == L+1) break;
				}
			}
			
			if(P >= L) break;
			cnt++;
		}
		
		System.out.print(result[L] == Integer.MAX_VALUE ? -1 : result[L]);
	}
	
	static class Info {
		int a, b;
		Info(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}