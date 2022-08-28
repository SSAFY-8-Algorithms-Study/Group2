package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16918 {
	
	static int R; // 행
	static int C; // 열 
	static int N; // 초 
	static int[][] map; // 맵 - 폭탄의 시간을 담은 배열 
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C]; // 폭탄이 설치된 초를 저장한다 
		for (int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j=0; j<C; j++) {
				if (str.charAt(j)=='O') map[i][j] = 0; // 초기 폭탄은 0초에 설치됨 
				else map[i][j] = -1; // 빈 칸은 -1로 설정 
			}
		}
		boolean isFire = true; // 폭탄의 설치와 폭발의 반복 체크 
		int t = 0;
		while (t<N) {
			t++; // 시간초 경과 
			if (isFire) { // 폭발 - 설치 후 3초가 경과된 폭탄 폭발 
				for (int i=0; i<R; i++) {
					for (int j=0; j<C; j++) {
						if(map[i][j]==t-3) { // 3초 전에 설치한 폭탄이다 
							map[i][j] = -1; // 폭탄이 있는 칸도 빈 칸으로 
							for (int d=0; d<4; d++) {
								int ny = i + dy[d];
								int nx = j + dx[d];
								if (0<=ny && ny<R && 0<=nx && nx<C && map[ny][nx] != t-3) map[ny][nx] = -1; // 폭탄이 아니면 모두 폭발시킨다 
							}
						}
					} // end j
				} // end i
			} else { // 설치 
				for (int i=0; i<R; i++) {
					for (int j=0; j<C; j++) {
						if (map[i][j] == -1) map[i][j] = t; // 폭탄 세팅 - 현재 초 기록 
					}
				}	
			}
			isFire = !isFire; // toggle
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j]==-1) sb.append(".");
				else sb.append('O');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
