package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj9205 { // 맥주 마시면서 걸어가기 
	
	static boolean isPossible(int y1, int x1, int y2, int x2) {
		if (Math.abs(y1-y2) + Math.abs(x1-x2) <= 1000) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		for (int testcase=0; testcase<T; testcase++) {
			int N = Integer.parseInt(br.readLine()); 
			// 상근이네 집 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			
			// 편의점 
			int[][] store = new int[N][2];
			for (int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				store[n] = new int[] {y,x};
				
			}
			// 페스티벌 좌표 
			st = new StringTokenizer(br.readLine());
			int ty = Integer.parseInt(st.nextToken());
			int tx = Integer.parseInt(st.nextToken());
			// 탐색 
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.add(new int[] {sy,sx});
			boolean flag = false;
			boolean[] visited = new boolean[N];
			while (!q.isEmpty()) {
				int[] arr = q.poll();
				int y = arr[0];
				int x = arr[1];
				
				if (isPossible(y,x,ty,tx)) {
					System.out.println("happy");
					flag = true;
					break;
				}
				
				for (int n=0; n<N; n++) {
					if (!visited[n] && isPossible(y,x,store[n][0], store[n][1])) {
						visited[n] = true;
						q.add(store[n]);
					}
				}
			}
			
			if (!flag) System.out.println("sad");
		}
	}

}
