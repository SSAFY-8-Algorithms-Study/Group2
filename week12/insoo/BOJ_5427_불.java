import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * BOJ 5427 Gold 4
 * 불
 * BFS
 */
public class BOJ_5427_불 {
	static int w, h;
	static int[] rDir = {0, 1, 0, -1};
	static int[] cDir = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int ntc = 0; ntc < tc; ntc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int wStart = 0;
			int hStart = 0;
			
			char[][] map = new char[h][w];
			
			ArrayDeque<int[]> q = new ArrayDeque<>();
			
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if(map[i][j] == '*') {
						q.add(new int[] {i, j, 1, 0});
					} else if(map[i][j] == '@') {
						map[i][j] = '.';
						hStart = i;
						wStart = j;
					}
				}
			}
			q.add(new int[] {hStart, wStart, 0, 0});
			
			int answer = 0;
			
			while(!q.isEmpty()) {
				int[] e = q.poll();
				int r = e[0];
				int c = e[1];
				int t = e[2];
				int cnt = e[3];
				
				for (int i = 0; i < 4; i++) {
					int nr = r + rDir[i];
					int nc = c + cDir[i];
					
					if(t == 0 && !(checkRange(nr,nc))) {
						answer = cnt + 1;
						q.clear();
						break;
					}
					
					if(checkRange(nr,nc) && map[nr][nc] == '.') {
						map[nr][nc] = '#';
						q.add(new int[] {nr, nc, t, cnt+1});
					}
				}
			}
			
			sb.append((answer == 0 ? "IMPOSSIBLE" : answer) + "\n");
		}
		
		System.out.print(sb);
	}
	
	static boolean checkRange(int r, int c) {
		return r>=0 && r<h && c>=0 && c<w ? true : false;
	}
}