package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ18428 { // 감시 피하기
	static int N;
	static char[][] map;
	static ArrayList<int[]> tList;
	static ArrayList<int[]> xList;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static String result = "NO";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		tList = new ArrayList<>();
		xList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') tList.add(new int[] {i, j});
				if(map[i][j] == 'X') xList.add(new int[] {i, j});
			}
		}
		
		block(0, 0);
		System.out.println(result);
	}
	
	static void block(int cnt, int start) {
		if(cnt == 3) {
			if(isPossible()) {
				result = "YES";
			}
			
			return;
		}
		
		for(int i = start; i < xList.size(); i++) {
			if(!result.equals("YES")) {
				map[xList.get(i)[0]][xList.get(i)[1]] = 'O';
				block(cnt + 1, i + 1);
				map[xList.get(i)[0]][xList.get(i)[1]] = 'X';				
			}
		}
	}
	
	static boolean isPossible() {
		for(int[] t : tList) {
			for(int d = 0; d < 4; d++) {
				int x = t[0];
				int y = t[1];
				
				while(true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
					if(map[nx][ny] == 'O') break;
					if(map[nx][ny] == 'S') return false;
					
					x = nx; y = ny;
				}
			}
		}
		
		return true;
	}
}
