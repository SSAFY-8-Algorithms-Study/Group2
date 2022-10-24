package boj;

import java.io.*;
import java.util.*;

public class Boj1043 { // 거짓말 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		if (t == 0 ) {
			System.out.println(M);
		} else {
			int ans = M;
			boolean[][] g = new boolean[N+1][N+1]; // 친구 리스트 
			ArrayList<Integer>[] party = new ArrayList[N+1]; // 참여한 파티 리스트 
			for (int i=1; i<=N; party[i++] = new ArrayList<Integer>());
			
			int[] truth = new int[t]; // 진실을 아는 친구 
			for (int i=0; i<t; i++) {
				truth[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int[] member = new int[n];
				for (int j=0; j<n; j++) {
					member[j] = Integer.parseInt(st.nextToken());
					party[member[j]].add(i);
				}
				
				for (int j=0; j<n-1; j++) {
					for (int k=j+1; k<n; k++) {
						g[member[j]][member[k]] = true;
						g[member[k]][member[j]] = true;
					}
				}
			}
			
			// 진실을 아는 사람들과 연결된 사람들이 방문한 파티 빼기 
			boolean[] pvisited = new boolean[M+1]; // 파티 방문 체크 
			boolean[] fvisited = new boolean[N+1]; // 친구 방문 체크 
			ArrayDeque<Integer> q = new ArrayDeque<>();  // 진실을 아는 친구들 모두 탐색 
			for (int friend : truth) {
				if (!fvisited[friend]) {
					fvisited[friend] = true;
					q.add(friend);
					while (!q.isEmpty()) {
						int f = q.poll();
						for (int p : party[f]) { // 진실을 아는 친구가 참여한 파티 정답에서 빼기 
							if (!pvisited[p]) {
								pvisited[p] = true;
								ans--;
							}
						}
						for (int i=1; i<=N; i++) { // 진실을 아는 친구들과 연결된 친구들 큐에 추가 
							if (g[f][i] && !fvisited[i]) {
								fvisited[i] = true;
								q.add(i);
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}
