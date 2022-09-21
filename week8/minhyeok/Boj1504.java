package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1504 { // 특정한 최단 경로 
	
	static int N;
	static ArrayList<ArrayList<int[]>> g;
	static int v1;
	static int v2;
	static boolean reachable = true;

	static int dijkstra(int start, int end) { // 다익스트라 
		PriorityQueue<int[]> pq =  new PriorityQueue<int[]>((o1,o2)->{return o1[1]-o2[1];});
		pq.add(new int[] {start,0});
		int[] maxWeight = new int[N+1];
		maxWeight[start] = 0;
		Arrays.fill(maxWeight, Integer.MAX_VALUE);
		while(!pq.isEmpty()) {
			int[] curE = pq.poll();
			int n = curE[0];
			int w = curE[1];
				
			if (n==end) {
				return w;
			} 
			
			for (int[] edge: g.get(n)) {
				int nextNode = edge[0];
				if (maxWeight[nextNode] > w + edge[1]) {
					maxWeight[nextNode] = w + edge[1];
					pq.add(new int[] {nextNode, w + edge[1]});
				}
			}
		}
		reachable = false;
		return maxWeight[end];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		g = new ArrayList<ArrayList<int[]>>();
		for (int i=0; i<N+1; i++) {
			g.add(new ArrayList<int[]>());
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			g.get(from).add(new int[]{to,w});
			g.get(to).add(new int[]{from,w});
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int a1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,N);
		int a2 = dijkstra(1,v2) + dijkstra(v2,v1) +dijkstra(v1,N);
		
		if (!reachable) System.out.println(-1);
		else System.out.println(Math.min(a1, a2));
	}

}
