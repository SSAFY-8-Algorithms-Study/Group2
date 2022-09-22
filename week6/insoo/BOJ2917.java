import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * BOJ 2917 Gold 2
 * 늑대 사냥꾼
 */
public class BOJ_2917_늑대사냥꾼 {
	static int N, M, min;
	static int[] xDir = {0, 1, 0, -1};
	static int[] yDir = {1, 0, -1, 0};
	static String[][] map;
	
	static class Point {
		int x, y, d;
		Point(int x, int y, int d) {
			this.x = x; // 행
			this.y = y; // 열
			this.d = d; // 나무와의 거리
		}
	}
	
	static void navigate(Point start, Point target) { // 길 탐색
		boolean[][] visited = new boolean[N][M];
		PriorityQueue<Point> q = new PriorityQueue<>((a,b) -> b.d - a.d); // 안전한 경로 우선 탐색
		
		int startDist = Integer.parseInt(map[start.x][start.y]);
		q.add(new Point(start.x, start.y, startDist));
		visited[start.x][start.y] = true;
		
		while(!q.isEmpty()) {
			Point po = q.poll();

			if(po.x == target.x && po.y == target.y) {
				min = po.d; // 타겟 도착 시 최소 거리
				return;
			}

			for (int i = 0; i < 4; i++) {
				int xx = po.x + xDir[i];
				int yy = po.y + yDir[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<M && !visited[xx][yy] && !map[xx][yy].equals("+")) {
					int v = Integer.parseInt(map[xx][yy]);
					q.add(new Point(xx, yy, Math.min(po.d, v))); // 경로 중 최소거리
					visited[xx][yy] = true;
				}
			}
		}
		min = 0; // target에 닿지 못 했을 때
	}
	
	static void draw(ArrayDeque<Point> q) { // 트리 주변 BFS로 거리 표시
		while(!q.isEmpty()) {
			Point po = q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = po.x + xDir[i];
				int yy = po.y + yDir[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<M && map[xx][yy].equals(".")) {
					map[xx][yy] = po.d+1+"";
					q.add(new Point(xx, yy, po.d+1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		Point start = null;
		Point target = null;
		map = new String[N][M];
		min = Integer.MAX_VALUE;
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if(map[i][j].equals("+")) q.add(new Point(i,j,0));
				else {
					if(map[i][j].equals("V")) start = new Point(i,j,0);
					else if(map[i][j].equals("J")) target = new Point(i,j,0);
					map[i][j] = ".";
				}
			}
		}
		draw(q); // 트리와의 거리 BFS
		navigate(start, target); // 길 탐색 트리와의 최소 거리 BFS
		System.out.print(min);
	}
}