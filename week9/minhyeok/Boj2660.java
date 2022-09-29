package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2660 { // 회장뽑기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<N+1; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		// 입력 받기 
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if (from == -1 && to == -1) break;
			
			g.get(from).add(to);
			g.get(to).add(from);
		}
		
		// 연결된 모든 노드 탐색 - BFS
		int min = Integer.MAX_VALUE;
		int minCnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<N+1; i++) {
			ArrayDeque<Integer> aq = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			visited[i] = true;
			for (int n : g.get(i)) {
				visited[n] = true;
				aq.add(n);
			}
			int cnt = 0;
			while (!aq.isEmpty()) {
				int size = aq.size();
				cnt++;
				for (int s=0; s<size; s++) {
					
					int node = aq.poll();
					
					for (int nn : g.get(node)) {
						if (!visited[nn]) {
							visited[nn]= true;
							aq.add(nn);
						}
					}
				}
			} // end while
			if (min > cnt) {
				min = cnt;
				sb = new StringBuilder();
				sb.append(i+" ");
				minCnt = 1;
			} else if (cnt == min) {
				sb.append(i+ " ");
				minCnt++;
			}
		} // end for
		
		System.out.println(min + " " + minCnt );
		System.out.println(sb);
	}

}
