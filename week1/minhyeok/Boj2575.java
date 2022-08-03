package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj2575 {
	
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,-1,0,1};
	static boolean isIce = true;
	static int ans = 0;
	
	static int[][] meltIce(){
		int[][] newArr = new int[N][M];
		for (int i=1;i<N-1;i++) {
			for (int j=1;j<M-1;j++) {
				int cnt = 0; // count sea
				if (arr[i][j]>0) {
					for (int t=0;t<4;t++) {
						int ny = i+dy[t];
						int nx = j+dx[t];
						if (arr[ny][nx]<=0) {
							cnt +=1;
						}
					}
				}
				newArr[i][j] = arr[i][j] - cnt;
			}
		}
		
		return newArr;
	}
	
	static boolean checkIce() {
		for (int i=1;i<N-1;i++) {
			for (int j=1;j<M-1;j++) {
				if (arr[i][j] > 0) {
					return true;
				}
			}
		}
		ans = 0;
		return false;

	}
	
	static void dfs(int i, int j) {
		for (int t=0;t<4;t++) {
			int ny = i+dy[t];
			int nx = j+dx[t];
			if (ny>=1&&ny<N-1&&nx>=1&&nx<M-1&&arr[i][j]>0&&!visited[ny][nx]) {
				visited[ny][nx]=true;
				dfs(ny,nx);
			}
		}
	}
	
//	static void bfs(int i, int j) {
//		LinkedList<int[]> q = new LinkedList<int[]>();
//		q.add(new int[]{i,j});
//		while (q.size()>0) {
//			int[] yx = q.pop();
//			int y = yx[0];
//			int x = yx[1];
//			for (int t=0;t<4;t++) {
//				int ny = y+dy[t];
//				int nx = x+dx[t];
//				if (arr[ny][nx]>0 && !visited[ny][nx]) {
//					visited[ny][nx] = true;
//					q.add(new int[] {ny,nx});
//				}
//			}
//		}
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());;
			}
		}
		
		while(isIce) {
			ans++;
			arr = meltIce();
			isIce = checkIce(); // check if ice exists
			
			// Search - DFS
			visited = new boolean[N][M];
			int parts = 0; // count connected ice area
			for (int i=1;i<N-1;i++) {
				for (int j=1;j<M-1;j++) {
					if (arr[i][j] > 0 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i,j); // 444ms
						// bfs(i,j);  560ms
						parts++;
					}
					if (parts >= 2) {
						isIce = false;
					}
				}	
			}
		}
		
		System.out.println(ans);
	}

}
