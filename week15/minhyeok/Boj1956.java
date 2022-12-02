package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1956 { // 운동 - 플로이드 워셜 알고리즘

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		long[][] dist = new long[V + 1][V + 1]; // 최단경로를 저장할 배열 
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				dist[i][j] = Long.MAX_VALUE;
			}
		}
		

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			dist[from][to] = cost;
		}
		
		for (int k=1; k<=V; k++) { // 노드 k를 거쳐 가보자 ! 
			for (int i=1; i<=V; i++) {
				for (int j=1; j<=V; j++) {
					if (dist[i][k] == Long.MAX_VALUE || dist[k][j] == Long.MAX_VALUE) continue; // 하나의 경로라도 갈 수 없는 경우 패스 
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); // i에서 j로 가는 최단경로는 Min(i->j, i->k->j)
				}
			}
		}
		long ans = Long.MAX_VALUE;
		for (int i = 1; i <= V; i++) {
			ans = Math.min(ans, dist[i][i]); // 최솟값 찾기 
		}
		if (ans == Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

}
