import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * BOJ 3187 Silver 1
 * 양치기 꿍
 */
public class BOJ_3187_양치기꿍 {
	static int sheep, wolf;
	static int[] rDir = {0, 1, 0, -1};
	static int[] cDir = {1, 0, -1, 0};
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 'v' || map[r][c] == 'k') bfs(r, c);
			}
		}
		
		System.out.printf("%d %d", sheep, wolf);
	}
	
	static void bfs(int or, int oc) {
		int cntSheep = 0;
		int cntWolf = 0;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {or, oc});
		
		if(map[or][oc] == 'v') cntWolf++;
		else if(map[or][oc] == 'k') cntSheep++;
		map[or][oc] = '#';
		
		while(!q.isEmpty()) {
			int[] el = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = el[0] + rDir[d];
				int nc = el[1] + cDir[d];
				
				if(map[nr][nc] != '#') {
					if(map[nr][nc] == 'v') cntWolf++;
					else if(map[nr][nc] == 'k') cntSheep++;
					map[nr][nc] = '#';
					
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		if(cntSheep > cntWolf) sheep += cntSheep;
		else wolf += cntWolf;
	}
}