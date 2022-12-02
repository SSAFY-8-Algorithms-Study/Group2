package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj21609 { // 상어 중학교 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 격자 한 변의 크기 
		int M = Integer.parseInt(st.nextToken()); // 색상의 개수 
		
		// 격자 판 채우기 
		int[][] map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사방 탐색 테이블
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		// 정답 - 점수 총합
		int score = 0;
		// 오토 플레이 - 그룹이 존재하는 동안 계속 반복 
		while (true) {
			ArrayList<int[]> tBlocks = new ArrayList<int[]>(); // 제거할 가장 큰 블록 집합, 타겟 그룹  
			int tLenRainbow = 0; // 타겟 그룹의 무지개 블록의 
			// 1. 그룹 찾기 
			// 필요한 변수들 선언 
			boolean[][] visited = new boolean[N][N];
			
			// N x N 탐색 시작 
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// 일반 블록을 찾아 그룹 연결하기 
					if (!visited[i][j] && map[i][j] >= 1) { // 아직 방문하지 않은 일반 블록
						// 방문 체크
						visited[i][j] = true; 
						
						// 블록 관련 필요한 변수들 초기화 
						ArrayList<int[]> blocks = new ArrayList<int[]>(); // 블록 그룹
						int lenRainbow = 0; // 무지개 블록의 개수
						ArrayList<int[]> rainbows = new ArrayList<int[]>(); // 무지개색 블록들
						int color = map[i][j]; // 블록 그룹의 색 
						
						// 큐 초기화 
						ArrayDeque<int[]> q = new ArrayDeque<int[]>();
						q.add(new int[] {i,j}); 
						blocks.add(new int[] {i,j});
						
						// BFS
						while (!q.isEmpty()) {
							int[] arr = q.poll();
							int y = arr[0];
							int x = arr[1];
							// 사방 탐색
							for (int d=0; d<4; d++) {
								int ny = y + dy[d];
								int nx = x + dx[d];
								// 조건 필터링 - 맵 범위를 벗어나거나 인접 블록이 검은색이면 pass
								if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[i][j] == -1) continue; 
								// 아직 방문하지 않은 블록들 + 무지개 블록이나 그룹의 색과 같은 블록만 연결 
								if (!visited[ny][nx] && (map[ny][nx] == 0 || map[ny][nx] == color)) {
									visited[ny][nx] = true;
									q.add(new int[] {ny,nx}); // 큐에 추가 
									blocks.add(new int[] {ny,nx}); // 블록 그룹에 추가 
									if (map[ny][nx] == 0) {
										lenRainbow++; // 무지개색 개수 추가
										rainbows.add(new int[] {ny,nx}); // 무지개색 블록들 추가 
									}
								}
							} // end for
						} // end while - q
						
						// 무지개색 블록들은 재방문 허용
						for (int[] r: rainbows) {
							visited[r[0]][r[1]] = false;
						}
						
						// 블록 그룹의 크기가 1이하라면 pass
						if (blocks.size() <= 1) continue;
						
						// 타겟 그룹 갱신 (크기, 무지개 블록 수, 기준 블록 행,열)
						boolean isReplace = false;
						if (tBlocks.size() < blocks.size()) isReplace = true; 
						else if (tBlocks.size() == blocks.size()) {
							if (tLenRainbow <= lenRainbow) isReplace = true;
						}
						if (isReplace) {
							tBlocks = blocks;
							tLenRainbow = lenRainbow; // 타겟 그룹의 무지개 블록의 개수 
						}
						
					} // end if - check normal block
				} // end j
			} // end i
			
			// 타겟 그룹이 존재하는지 체크
			if (tBlocks.size() < 2) break;
			
			// 2. 타겟 블록 그룹 제거 + 점수 획득
			score += tBlocks.size() * tBlocks.size();
			for (int[] block : tBlocks) {
				map[block[0]][block[1]] = -2;
			}
			
			// 3. 중력 작용 -> 90도 반시계 방향 회전 -> 중력 작용 
			int cnt=0;
			while (true) {
				cnt++;
				// 중력 작용 
				for (int j=0; j<N; j++) {
					for (int i=N-1; i>=0; i--) {
						// 빈 칸이라면 위에 있는 블록 땡겨오기
						if (map[i][j] == -2) {
							int k = i-1;
							while (k>=0) {
								if (map[k][j] == -1) break; // 검은색 블록은 중력 영향을 받지 않는다 
								if (map[k][j] >=0) { // 무지개 블록이나 일반 블록 
									map[i][j] = map[k][j]; // 현재 빈 칸으로 가져오기 
									map[k][j] = -2; // 가져온 블록의 칸을 빈 칸 처리 
									break;
								}
								k--;
							} // end while 
						} // end if
					} // end i - row
				} // end j - col
				if (cnt==2) break;
				
				
				// 90도 반시계 방향 회전 
				int[][] newMap = new int[N][N];
				for (int i=0; i<N; i++) for (int j=0; j<N; j++) newMap[N-1-j][i] = map[i][j];					
				map = newMap;
			}
		} // end while
		System.out.println(score);
	}
	
	
}
