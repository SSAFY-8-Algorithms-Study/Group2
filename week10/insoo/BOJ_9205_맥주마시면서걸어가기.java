package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * BOJ 9205 Silver 1
 * 맥주 마시면서 걸어가기
 */
public class BOJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int nt = 0; nt < t; nt++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int xStart = Integer.parseInt(st.nextToken());
			int yStart = Integer.parseInt(st.nextToken());
			
			Point[] list = new Point[n+1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[i] = new Point(x,y);
			}
			
			st = new StringTokenizer(br.readLine());
			int xTarget = Integer.parseInt(st.nextToken());
			int yTarget = Integer.parseInt(st.nextToken());
			list[n] = new Point(xTarget, yTarget);

			boolean result = false;
			boolean[] visited = new boolean[n+1];
			
			ArrayDeque<Point> q = new ArrayDeque<>();
			q.add(new Point(xStart, yStart));
			
			while(!q.isEmpty()) {
				Point el = q.poll();
				int x = el.x;
				int y = el.y;
				
				if(x == xTarget && y == yTarget) {
					result = true;
					break;
				}
				
				for (int i = 0; i < list.length; i++) {
					int dist = Math.abs(x - list[i].x) + Math.abs(y - list[i].y);
					
					if(dist <= 1_000 && !visited[i]) {
						visited[i] = true;
						q.add(new Point(list[i].x, list[i].y));
					}
				}
			}
			
			System.out.println(result ? "happy" : "sad");
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