package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11403 { // 경로 찾기
	static int N;
	static int[][] adjArr;
	static int[][] result;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjArr = new int[N][N];
		result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adjArr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		
		for(int i = 0; i < N; i++) {
			visit = new boolean[N];
			dfs(i, i);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int num, int cur) {
		for(int i = 0; i < N; i++) {
			if(adjArr[cur][i] == 1 && !visit[i]) {
				result[num][i] = 1;
				visit[i] = true;
				dfs(num, i);
			}
		}
	}
}
