package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1388 { // 바닥 장식
	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new char[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visit[i][j]) {
					bfs(i, j);
					result++;					
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			char chr = map[node[0]][node[1]];
			
			if(chr == '-') {
				if(node[1] + 1 < M) {
					if(map[node[0]][node[1] + 1] == '-' && !visit[node[0]][node[1] + 1]) {
						queue.add(new int[] {node[0], node[1] + 1});
						visit[node[0]][node[1] + 1] = true;
					}
				}
			}
			
			if(chr == '|') {
				if(node[0] + 1 < N) {
					if(map[node[0] + 1][node[1]] == '|' && !visit[node[0] + 1][node[1]]) {
						queue.add(new int[] {node[0] + 1, node[1]});
						visit[node[0] + 1][node[1]] = true;
					}
				}
			}
		}
	}
}
