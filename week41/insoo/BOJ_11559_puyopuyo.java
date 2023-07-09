package pending;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class BOJ_11559_puyopuyo {
	static int cntSeq;
	static int[] rDir = {0, 1, 0 ,-1};
	static int[] cDir = {1, 0, -1, 0};
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		
		for (int r = 0; r < 12; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		while(true) { // 반복
			boolean found = false; // 찾았나?
			if(find()) { // 찾았다면
				found = true;
				cntSeq++; // 시퀀스 추가
				gravity(); // 중력 작용
			}
			
			if(!found) break; // 못 찾았다면 탈출
		}
		
		System.out.print(cntSeq);
	}
	
	static boolean find() { // 4개 뭉친 거 찾기
		boolean flag = false;
		ArrayDeque<int[]> q = new ArrayDeque<>(); // BFS
		int[][] visit = new int[12][6];
		int idx = 0; // BFS memo 활용
		
		for (int r = 0; r < 12; r++) {
			for (int c = 0; c < 6; c++) {
				idx++;
				
				if(visit[r][c] != 0 || map[r][c] == '.') continue;
				visit[r][c] = idx; // 4개 이상일 때 같은 인덱스 표시 된 것 체크하기 위함
				
				q.add(new int[] {r, c});
				int cnt = 0;
				
				while(!q.isEmpty()) {
					int[] now = q.poll();
					
					cnt++;
					
					for (int d = 0; d < 4; d++) { // 4방 탐색
						int nr = now[0] + rDir[d];
						int nc = now[1] + cDir[d];
						
						
						if(0<=nr && nr<12 && 0<=nc && nc<6 && visit[nr][nc] == 0 && map[nr][nc] == map[r][c]) {
							q.add(new int[] {nr, nc});
							visit[nr][nc] = idx;
						}
					}
					
				}
				
				if(4 <= cnt) {
					flag = true;
					for (int i = 0; i < 12; i++) {
						for (int j = 0; j < 6; j++) {
							if(visit[i][j] == idx) map[i][j] = '.'; // 4개 이상 시 같은 인덱스 표시된 곳 터트리기
						}
					}
				}
			}
		}
		
		return flag;
	}
	
	static void gravity() { // 중력 작용
		for (int c = 5; 0 <= c; c--) { // 각 열별로
			for (int r = 10; 0 <= r; r--) { // 아래부터 올라가며 행 비교
				if(map[r][c] != '.' && map[r+1][c] == '.') {
					int nr = r+1;
					
					while(nr+1 < 12 && map[nr+1][c] == '.') nr++; // 땅에 닿을 때까지
					
					map[nr][c] = map[r][c];
					map[r][c] = '.';
				}
			}
		}
	}
}