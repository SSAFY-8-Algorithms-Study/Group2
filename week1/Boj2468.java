package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2468 {
	
	static boolean[][] visited; // default value -> false
	static int ans = 1;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	static void search(int[][]a ,int i,int j,int r) { // DFS
		int n = a.length;
		for (int t=0;t<4;t++) {
			int ny = i+dy[t];
			int nx = j+dx[t];
			if (ny>=0 && ny<n && nx>=0 && nx<n) {
				if (!visited[ny][nx] && a[ny][nx]-r>0) {
					visited[ny][nx] = true;
					search(a,ny,nx,r);
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int maxLevel=1;
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxLevel = Math.max(arr[i][j], maxLevel);
			}
		}
		
		
		
		// r -> rain level
		for (int r=1;r<maxLevel;r++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (arr[i][j]-r>0 && !visited[i][j]) {
						search(arr,i,j,r);
						cnt += 1;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

}
