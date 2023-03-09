package pending;
import java.io.*;
import java.util.*;
class BOJ_20125_쿠키의신체측정 {
	static int[] cDir = {1, 0, -1, 0};
	static int[] rDir = {0, 1, 0, -1};
	static int N;
	static char[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 1; i < N-1; i++) {
			col:
			for (int j = 1; j < N-1; j++) {
				for (int d = 0; d < 4; d++) {
					if(map[i+rDir[d]][j+cDir[d]] == '_') continue col;
				}
				sb.append((i+1) + " " + (j+1) + "\n"); // heart
				
				find(i, j-1, 0, -1); // left arm
				find(i, j+1, 0, 1); // right arm
				
				int body = find(i+1, j, 1, 0); // body
				
				find(i+body+1, j-1, 1, 0); // left leg
				find(i+body+1, j+1, 1, 0); // right leg
			}
		}
		
		System.out.print(sb);
	}
	
	static int find(int r, int c, int rDist, int cDist) {
		int cnt = 0;
		
		while(0 <= r && r < N && 0 <= c && c < N) {
			if(map[r][c] == '_') break;
			cnt++;
			r += rDist;
			c += cDist;
		}
		
		sb.append(cnt + " ");
		return cnt;
	}
}