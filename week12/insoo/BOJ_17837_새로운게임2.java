import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * BOJ 17837 Gold 2
 * 새로운 게임
 */
public class BOJ_17837_새로운게임2 {
	static int N;
	static int[] rDir = {0, 0, -1, 1}; // R L U D
	static int[] cDir = {1, -1, 0, 0};
	static int[][] board;
	static Info[] RC;
	static ArrayDeque<Info> q;
	static ArrayDeque<Info>[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		RC = new Info[M]; // 말 번호로 말 위치 관리
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map = new ArrayDeque[N][N]; // 스택으로 관리
		for(ArrayDeque<Info>[] e : map) for (int i = 0; i < N; i++) e[i] = new ArrayDeque<>();
		
		q = new ArrayDeque<>(); // 큐로 관리
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			map[r][c].push(new Info(i, d, 0));
			q.add(new Info(i,d,0));
			RC[i] = new Info(r,c);
		}
		
		System.out.print(bfs());
	}
	
	static int bfs() {
		while(!q.isEmpty()) {
			Info e = q.poll();
			int r = RC[e.n].r;
			int c = RC[e.n].c;
			int d = e.d;

			if(e.cnt > 1_000) return -1;

			ArrayDeque<Info> pices = new ArrayDeque<>(); // 스택으로 관리
			
			int mapSize = map[r][c].size();
			for (int i = 0; i < mapSize; i++) { // map에 쌓인 말 불러오기
				Info info = map[r][c].pop();
				pices.push(info);
				if(info.n == e.n) break;
			}
			
			int picesSize = pices.size();
			
			int nr = r + rDir[d];
			int nc = c + cDir[d];
			
			boolean reverse = false;
			
			// 이동 칸 탐색
			if(!checkRange(nr,nc) || board[nr][nc] == 2) { // 파란 칸, 경계밖
				d = d % 2 == 1 ? d - 1 : d + 1; // 반대 방향
				nr = r + rDir[d];
				nc = c + cDir[d];
				
				if(!checkRange(nr,nc) || board[nr][nc] == 2) { // 다음 칸도 (파란 칸, 경계 밖), 움직임 X
					nr = r;
					nc = c;
				} else if(board[nr][nc] == 1) { // 움직임 O, 빨간 칸
					reverse = true;
				} // 움직임 O 흰칸 default
			}
			else if(board[nr][nc] == 1) { // 빨간 칸
				reverse = true;
			} // 흰 칸은 default

			// 말 이동 반영
			for (int i = 0; i < picesSize; i++) {
				Info info = reverse ? pices.pollLast() : pices.pop();
				
				RC[info.n] = new Info(nr, nc);
				map[nr][nc].push(info);
			}
			q.add(new Info(e.n, d, e.cnt+1));	
			if(map[nr][nc].size() >= 4) return e.cnt+1;
		}
		return -1;
	}

	static boolean checkRange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N ? true : false;
	}
	
	static class Info{
		int r, c, n, d, cnt;
		
		Info(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		Info(int n, int d, int cnt) {
			super();
			this.n = n;
			this.d = d;
			this.cnt = cnt;
		}
	}
}