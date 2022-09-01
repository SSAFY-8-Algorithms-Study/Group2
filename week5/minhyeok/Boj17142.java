package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj17142 {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] virus;
	static int virusCnt;
	static boolean[] selected; // 선택된 조합들을 담은 배열 
	static ArrayDeque<int[]> pq; // 바이러스들을 담을 큐 
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans = -1; // 모든 빈 칸에 바이러스가 있게 되는 최소 시간 
	static boolean[][] visited;
	static int blank; // 빈 칸의 수 
	
	static void bfs() {
		int day = 0; // 바이러스 조합 별 소요 시간 카운트 
		int blankCnt = 0; // 조합에 따른 연구수의 빈 칸 카운트 
		if (blankCnt==blank) { // 모든 연구소를 방문했다 
			ans = (ans==-1) ? day : Math.min(ans, day); 
			return;
		}
		while (!pq.isEmpty()) { // 바이러스 퍼뜨리기 
			int size = pq.size();
			for (int s=0; s<size; s++) { // 한 사이클 
				int[] v = pq.poll(); // 바이러스 뽑기
				int y = v[0];
				int x = v[1];
				for (int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] != 1 && !visited[ny][nx]) { // 연구소 범위 내, 벽이 아님, 아직 방문하지 않은 위치 
						visited[ny][nx] = true;
						pq.offer(new int[] {ny,nx});
						if (map[ny][nx]==0) blankCnt++; // 빈 칸으로 퍼졌으면 카운트 
					}
				}
			} // end size
			day++; // 하루 지남
			if (blankCnt==blank) { // 모든 연구소를 방문했다 
				ans = (ans==-1) ? day : Math.min(ans, day);
				return;
			}
		} // end while
	}
	
	static void comb(int start, int cnt) {
		if (cnt == M) {
			pq = new ArrayDeque<int[]>(); // 바이러스 y, x
			visited = new boolean[N][N]; // 바이러스의 방문을 체크할 배열
			for (int i=0; i<virusCnt; i++) {
				if (selected[i]) {
					visited[virus[i][0]][virus[i][1]] = true;
					pq.offer(new int[] {virus[i][0], virus[i][1]}); // 선택된 바이러스의 좌표 정보를 큐에 추가
				}
			}
			bfs();
			return;
		}
		
		for (int i=start; i<virusCnt; i++) { // 바이러스 개수 중 M개 선택하기 
			selected[i] = true;
			comb(i+1,cnt+1);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소의 크기 
		M = Integer.parseInt(st.nextToken()); // 바이러스의 개수 
		virus = new int[10][2]; // 바이러스의 y,x 좌표 
		virusCnt = 0; // M보다 작거나 같은 수, 바이러스 개수 세기 
		map = new int[N][N]; // 연구소 맵 
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); // 행 한 줄 입력 
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) virus[virusCnt++] = new int[] {i,j}; // 바이러스의 위치 좌표 저장 
				if (map[i][j] == 0) blank++; // 연구소의 빈 칸 개수
			}
		}
		selected = new boolean[virusCnt]; // 바이러스 조합 M개 선택  
		comb(0,0); // 조합 시작 (시작 위치, 카운트)
		System.out.println(ans);
		
	}

}
