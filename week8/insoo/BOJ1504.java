package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * BOJ 1504 Gold 4
 * 특정한 최단 경로
 */
public class BOJ_1504_특정한최단경로 {
	static class Path {
		int from, dist, v, w;
		Path(int from, int dist, int v, int w) {
			this.from = from; // 정점
			this.dist = dist; // 거리
			this.v = v; // 정점 1 방문 여부
			this.w = w; // 정점 2 방문 여부
		}
	}
	
	static int N;
	static ArrayList<Path>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 수
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		list = new ArrayList[800];
		
		for (int i = 0; i < 800; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Path(b,c,0,0));
			list[b].add(new Path(a,c,0,0));
		}

		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken())-1; // 정점 1
		int w = Integer.parseInt(st.nextToken())-1; // 정점 2
		
		System.out.print(bfs(v, w));
	}

	static int bfs(int v, int w) {
		PriorityQueue<Path> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist); // 최소 거리 우선 탐색
		pq.add(new Path(0,0,0,0)); // 시작 정점
		int[][][] visited = new int[800][2][2]; // 정점 from, 정점 v, 정점 w 방문 확인
		for(int[][] e : visited) for(int[] el : e) Arrays.fill(el, Integer.MAX_VALUE);
		
		visited[0][0][0] = 0;
		
		while(!pq.isEmpty()) {
			Path pa = pq.poll();

			int from = pa.from;
			if(from == v) pa.v = 1; // 정점 v를 지날 때 1 할당
			if(from == w) pa.w = 1; // 정점 w를 지날 때 1 할당 
			if(pa.v == 1 && pa.w == 1 && from == N-1) return pa.dist; // 두 정점을 지나고 정점 N에 도착
			
			ArrayList<Path> nextPath = list[from]; // 간선이 있는 다음 정점들
			for (int i = 0; i < nextPath.size() ; i++) {
				Path next = nextPath.get(i);
				// 정점을 지나지 않고는 이전의 정점으로 돌아올 수 없음
				// 최단 거리가 있다면 갱신
				if(visited[next.from][pa.v][pa.w] < pa.dist + next.dist) continue;
				
				pq.add(new Path(next.from, pa.dist + next.dist, pa.v, pa.w));
				visited[next.from][pa.v][pa.w] = pa.dist + next.dist;
			}
		}
		return -1;
	}
}