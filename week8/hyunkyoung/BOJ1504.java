package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 { // 특정한 최단 경로
	static int N, E;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		list = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 첫번째 경우
		long res1 = (long)dij(1, v1) + dij(v1, v2) + dij(v2, N);
		// 두번째 경우
		long res2 = (long)dij(1, v2) + dij(v2, v1) + dij(v1, N);
		
		long result = Math.min(res1, res2);
		if(result >= Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	static int dij(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visit = new boolean[N + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			for(Node next : list[n.v]) {
				if(dist[next.v] > dist[n.v] + next.w) {
					dist[next.v] = dist[n.v] + next.w;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		return dist[end];
	}
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}
