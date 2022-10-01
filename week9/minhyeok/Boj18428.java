package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj18428 { // 감시 피하기 - 갑자기 조합 기억이 안남 ㅠ 
	
	static char[][] map;
	static int N;
	static boolean[][] visited;
	static boolean flag;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static ArrayList<int[]> t;
	static ArrayList<int[]> ob;
	
	private static boolean down (int ty, int tx) {
		int ny = ty+1;
		int nx = tx;
		while (ny < N) {
			if (map[ny][nx] == 'S') {
				return true;
			}
			
			if (map[ny][nx] == 'O') {
				return false;
			}
			
			ny += 1;
		}
		return false;
	}
	
	private static boolean left(int ty, int tx) {
		int ny = ty;
		int nx = tx-1;
		while (0 <= nx) {
			if (map[ny][nx] == 'S') {
				return true;
			}
			
			if (map[ny][nx] == 'O') {
				return false;
			}
			
			nx -= 1;
		}
		return false;
	}

	private static boolean right(int ty, int tx) {
		int ny = ty;
		int nx = tx+1;
		while (0 <= nx && nx < N) {
			if (map[ny][nx] == 'S') {
				return true;
			}
			
			if (map[ny][nx] == 'O') {
				return false;
			}
			
			nx += 1;
		}

		return false;
	}

	private static boolean up(int ty, int tx) {
		int ny = ty-1;
		int nx = tx;
		while (0 <= ny) {
			if (map[ny][nx] == 'S') {
				return true;
			}
			
			if (map[ny][nx] == 'O') {
				return false;
			}
			
			ny -= 1;
		}
		return false;
	}
	
	
	private static void dfs(int start, int cnt, boolean[][] visited) { // 모든 칸에 장애물을 3개 놓아보고 감시 피할 수 있는지 체크 
		if (cnt==3) {
			
			for (int[] teacher: t) {
				int ty = teacher[0];
				int tx = teacher[1];
				
				// up
				if (up(ty,tx)) {
					return;
				}
				
				// down
				if (down(ty,tx)) {
					return;
				}
				
				// right
				if (right(ty,tx)) {
					return;
				}
				
				// left
				if (left(ty,tx)) {
					return;
				}
			}
			flag = true;
			
			return;
		}
		
		
		for (int i=start; i < ob.size(); i++) {
			int[] o = ob.get(i);
			if (!visited[o[0]][o[1]]) {
				visited[o[0]][o[1]] = true;
				map[o[0]][o[1]] = 'O';
				dfs(start+1, cnt+1,visited);
				visited[o[0]][o[1]] = false;
				map[o[0]][o[1]] = 'X';
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		ob = new ArrayList<int[]>();
		t = new ArrayList<int[]>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				char c = st.nextToken().charAt(0);
				map[i][j] = c;
				if (c == 'T') {
					t.add(new int[] {i,j});
				} else if (c == 'X') {
					ob.add(new int[] {i,j});
				}
			}
		}
		
		visited = new boolean[N][N];
		dfs(0,0, visited); // 조합
		
		if (flag) System.out.println("YES");
		if (!flag) System.out.println("NO");
		
	}
}
