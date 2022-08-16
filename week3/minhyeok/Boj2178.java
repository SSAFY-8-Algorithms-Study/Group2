package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2178 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		visited[0][0]=true;
		pq.add(new Point(1,0,0));
		while (!pq.isEmpty()) {
			Point e = pq.poll();
			int cnt = e.cnt;
			int y = e.y;
			int x = e.x;
			
			if (y==N-1 && x==M-1) {
				System.out.println(cnt);
				break;
			}
			for (int t=0;t<4;t++) {
				int ny = y+dy[t];
				int nx = x+dx[t];
				if (0<=ny && ny<N && 0<=nx && nx<M) {
					if (arr[ny][nx]=='1' && !visited[ny][nx]) {
						visited[ny][nx] = true;
						pq.add(new Point(cnt+1,ny,nx));
					}
				}
			}
			
		}
	}

}

class Point implements Comparable<Point>{
	public int cnt;
	public int y;
	public int x;
	
	public Point(int cnt, int y, int x) {
		this.cnt = cnt;
		this.y = y;
		this.x = x;
	}
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.cnt-o.cnt;
	}
}