package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BOJ 2206 gold 4
 * 벽 부수고 이동하기
 * 1. Mark 클래스를 타입으로 가지는 큐 생성
 * 2. 출발지부터 도착지까지 큐를 사용한 bfs로 최단경로 구하기
 * 3. 벽을 만날 경우 최대 1번 벽을 부술 수 있는 crash변수 검사
 * 4. 벽을 부순 경우의 boolean 방문 배열을 따로 관리
 */
public class BOJ2206 {
	static int n, m;
	static int[] xDir = {0, 1, 0, -1};
	static int[] yDir = {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visited, crashedVisited;

	static class Mark {
		int x, y, cnt;
		boolean crash;
		Mark(int x, int y, int cnt, boolean crash)  {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.crash = crash;
		}
	}
	
	static int bfs(int x, int y) {
		// 1. Mark 클래스를 타입으로 가지는 큐 생성
		Queue<Mark> q = new LinkedList<>();
		
		visited[x][y] = true;
		q.offer(new Mark(x, y, 1, false));
		// 2. 출발지부터 도착지까지 큐를 사용한 bfs로 최단경로 구하기
		while(!q.isEmpty()) {
			Mark mk = q.poll();
			if(mk.x == n-1 && mk.y == m-1) return mk.cnt;
			for (int i = 0; i < 4; i++) {
				int xx = mk.x+xDir[i];
				int yy = mk.y+yDir[i];
				if(xx<0 || xx>=n || yy<0 || yy>=m) continue;
				if(visited[xx][yy] && mk.crash==false) continue;
				if(crashedVisited[xx][yy] && mk.crash==true) continue;
				if(map[xx][yy] == 1 && mk.crash==true) continue;
				// 3. 벽을 만날 경우 최대 1번 벽을 부술 수 있는 crash변수 검사
				if(map[xx][yy] == 1 && mk.crash==false) {
					visited[xx][yy] = true;
					q.add(new Mark(xx, yy, mk.cnt+1, true));
				} else {
					// 4. 벽을 부순 경우의 boolean 방문 배열을 따로 관리
					if(mk.crash == true) crashedVisited[xx][yy] = true;
					else visited[xx][yy] = true;
					q.add(new Mark(xx, yy, mk.cnt+1, mk.crash));
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 0; j < strs.length; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}

		visited = new boolean[n][m];
		crashedVisited = new boolean[n][m];
		System.out.print(bfs(0,0));
	}
}