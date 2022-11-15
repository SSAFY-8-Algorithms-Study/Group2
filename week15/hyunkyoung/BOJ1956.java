package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1956 { // 운동
	static int V, E;
	static ArrayList<Info>[] adjList;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 마을 수
		E = Integer.parseInt(st.nextToken()); // 도로 수
		
		adjList = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); // a -> b
			int c = Integer.parseInt(st.nextToken()); // 도로 길이
			
			adjList[a].add(new Info(b, c));
		}
		
		result = Integer.MAX_VALUE;
		for(int i = 1; i <= V; i++) {
			bfs(i);
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static void bfs(int num) {
		PriorityQueue<Info> queue = new PriorityQueue<>();
		boolean[][] visit = new boolean[V + 1][V + 1];
		queue.add(new Info(num, 0));
		
		while(!queue.isEmpty()) {
			Info node = queue.poll();
			
			if(node.v == num && node.e != 0) {
				result = Math.min(result, node.e);
				return;
			}

			for(Info next : adjList[node.v]) {
				if(!visit[node.v][next.v]) {
					visit[node.v][next.v] = true;
					queue.add(new Info(next.v, node.e + next.e));
				}
			}
		}
	}
	
	static class Info implements Comparable<Info> {
		int v, e;
		
		Info(int v, int e) {
			this.v = v;
			this.e = e;
		}

		@Override
		public int compareTo(Info o) {
			return this.e - o.e;
		}
	}
}
