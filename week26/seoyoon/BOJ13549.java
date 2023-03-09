package week26.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 13549 : 숨바꼭질 3 */
public class BOJ13549 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] time = new int[100001];
		Arrays.fill(time, Integer.MAX_VALUE);
		
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		time[N] = 0;
		q.add(N);
		
		while (!q.isEmpty()) {
			
			int cur = q.poll();

			if (cur == K) {
				System.out.println(time[K]);
				return;
			}
			
			if (cur - 1 >= 0 && (time[cur - 1] == Integer.MAX_VALUE || time[cur] + 1 < time[cur - 1])) {
				q.add(cur - 1);
				time[cur - 1] = time[cur] + 1;
			}
			if (cur + 1 <= 100000 && (time[cur + 1] == Integer.MAX_VALUE || time[cur] + 1 < time[cur + 1])) {
				q.add(cur + 1);
				time[cur + 1] = time[cur] + 1;
			}
			if (cur * 2 <= 100000 && (time[cur * 2] == Integer.MAX_VALUE || time[cur] < time[cur * 2])) {
				q.add(cur * 2);
				time[cur * 2] = time[cur];
			}
		}
		
	}
}