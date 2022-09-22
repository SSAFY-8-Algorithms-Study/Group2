package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * BOJ 1325 Silver 1
 * 효율적인 해킹
 * 실패... - 시간초과
 */
public class BOJ_1325_효율적인해킹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = 0;
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				list[B].add(A);
			}
		}

		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N+1];
			visited[i] = true;
			int cnt = 0;
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int from = q.poll();
				
				for (int j = 0; j < list[from].size(); j++) {
					int to = list[from].get(j);
					if(visited[to]) continue;
					if(from == to) continue;
					visited[to] = true;
					q.add(to);
					cnt++;
				}
			}
			if(cnt >= max) {
				if(cnt > max) {
					sb = new StringBuilder();
					max = cnt;
				}
				sb.append(i + " ");
			}
		}
		System.out.print(sb);
	}
}