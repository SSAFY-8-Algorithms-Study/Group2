import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BOJ 2178
 * 미로 탐색
 * 1. 1칸 이동한 좌표 큐에 넣기
 * 2. (N,M) 도착 시 이동 칸 수 반환
 */
public class BOJ2178 {
	static int n, m;
	static int[] xDir = {0, 1, 0, -1};
	static int[] yDir = {1, 0, -1, 0};
	static int[][] map;
	
	// 좌표와 이동 칸 수를 가지는 Mark 클래스
	static class Mark {
		int x, y, cnt;
		Mark(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int bfs(int x, int y) {
		Queue<Mark> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		visited[x][y] = true;
		q.offer(new Mark(x, y, 1));
		
		while(!q.isEmpty()) {
			Mark mk = q.poll();
			// (N,M) 도착 시 이동 칸 수 반환
			if(mk.x == n-1 && mk.y == m-1) return mk.cnt;
			
			for (int i=0; i < 4; i++) {
				int xx = mk.x + xDir[i];
				int yy = mk.y + yDir[i];
				if(xx<0 || xx>=n || yy<0 || yy>=m) continue;
				if(visited[xx][yy]) continue;
				if(map[xx][yy]==0) continue;
				
				visited[xx][yy] = true;
				// 1칸 이동한 좌표 큐에 넣기
				q.offer(new Mark(xx, yy, mk.cnt+1));
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
		
		for (int i = 0; i < n; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 0; j < strs.length; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		System.out.print(bfs(0,0));
	}
}