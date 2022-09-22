package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 17070 Gild 5
 * 파이프 옮기기 1
 */
public class BOJ_17070_파이프옮기기1 {
	static int N, cnt;
	static int[] xDir = {0, 1, 1}; // 가로 세로 대각선
	static int[] yDir = {1, 0, 1};
	static int[][] map;
	static int[][][] possible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreElements(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		possible = new int[N][N][3]; // 연결 가능 경우의 수 기록 배열
		pipe(0, 1, 0);
		System.out.print(cnt);
	}
	
	/** di 0 가로 1 세로 2 대각선 */
	static int pipe(int x, int y, int di) {
		if(x == N-1 && y == N-1) { // N,N 도착
			cnt++;
			return 1; // 방문 경우 증가
		}
		
		int sumPossible = 0;
		for (int i = 0; i < 3; i++) {
			int xx = x + xDir[i];
			int yy = y + yDir[i];
			if(xx>=0 && xx<N && yy>=0 && yy<N && map[xx][yy] != 1) {
				if(di == 0 && i == 1) continue; // 가로일 때 세로로 못 감
				if(di == 1 && i == 0) continue; // 세로일 때 가로로 못 감
				if(i == 2 && (map[xx-1][yy] == 1 || map[xx][yy-1] == 1)) continue; // 대각선일 때 빈칸 검사
				
				if(possible[xx][yy][i] != 0) { // 연결 가능한 경우가 있다면 바로 할당
				cnt += possible[xx][yy][i];
				sumPossible += possible[xx][yy][i];
				continue;
				}
				
				sumPossible += possible[xx][yy][i] = pipe(xx,yy,i); // 연결 가능 경우의 수 저장
			}
		}
		return sumPossible;
	}
}