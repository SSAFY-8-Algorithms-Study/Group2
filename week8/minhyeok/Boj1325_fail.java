package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj1325_fail { // 효율적인 해킹 

	static ArrayList<HashSet<Integer>> g;
	static boolean[] visited;
	static int cnt;
	
//	static void dfs(int n) {
//		if (g.get(n).size() == 0) return; 
//		
//		for (int nextNode: g.get(n)) { 
//			if (!visited[nextNode]) {
//				visited[nextNode] = true;
//				cnt++;
//				dfs(nextNode);
//			} 
//		}
//	}
	
	static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.add(n);
		visited = new boolean[10001];
		visited[n] = true;
		while (!q.isEmpty()) {
			int node = q.poll();
			
			visited[node] = true;
			
			for (int nn: g.get(node)) {
				if (!visited[nn]) {
					visited[nn] = true;
					q.add(nn);
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		g = new ArrayList<HashSet<Integer>>(); // 연결 그래프 초기화 
		for (int i=0; i<N+1; i++) {
			g.add(new HashSet<Integer>()); 
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g.get(b).add(a); // 자신을 신뢰하는 컴퓨터 연결 
		}
		System.out.println(g);
		int max = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<N+1; i++) {
			cnt=0;
//			visited = new boolean[N+1]; // 방문 체크 
//			visited[i] = true;
//			dfs(i);
			bfs(i);
			System.out.println(cnt);
			if (cnt > max) {
				max = cnt;
				sb = new StringBuilder();
				sb.append(i+" ");
			} else if (max == cnt) {
				sb.append(i+" ");
			}
		}
		
		// 정답 출력 
		System.out.println(sb);
	}

}
