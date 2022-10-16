package boj;

import java.io.*;
import java.util.*;

public class Boj11403 { // 경로 찾기 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] g = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				g[i][j] = (st.nextToken().charAt(0) == '1') ? true : false; // 인접 행렬 
			}
		}
		
		boolean[][] visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int j=0; j<N; j++) {
				if (g[i][j]) {
					q.add(j);
					visited[i][j] = true;
				}
			}
			while (!q.isEmpty()) {
				int node = q.poll();
				
				for (int k=0; k<N; k++) {
					if (!visited[i][k] && g[node][k]) { // 연결된 인접 노드 방문 
						visited[i][k] = true;
						q.add(k);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append((visited[i][j]) ? "1 " : "0 ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
