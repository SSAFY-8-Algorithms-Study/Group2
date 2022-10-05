package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9205 { // 맥주 마시면서 걸어가기
	static int N;
	static Point[] pArr;
	static boolean[] visit;
	static String res;
	static int bear;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 편의점 개수
			pArr = new Point[N + 2];
			visit = new boolean[N + 2];
			res = "sad";
			bear = 20;
			
			for(int n = 0; n < N + 2; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pArr[n] = new Point(x, y);
			}
			
			bfs();
			System.out.println(res);
		}
	}
	
	static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(pArr[0]);
		visit[0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == pArr[N + 1].x && p.y == pArr[N + 1].y) {
				res = "happy";
				return;
			}
			
			for(int i = 1; i < N + 2; i++) {
				if(!visit[i]) {
					double dist = Math.abs(p.x - pArr[i].x) + Math.abs(p.y - pArr[i].y);
					if(dist / 50 <= bear) {
						q.add(new Point(pArr[i].x, pArr[i].y));
						visit[i] = true;
						
						if(i != N + 1) bear = 20;
					}
				}
			}
		}
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
