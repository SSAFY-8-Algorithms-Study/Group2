package boj;

import java.io.*;
import java.util.*;

public class Boj17837 {
	
	static class Piece {
		int y, x, dir, idx; // 좌표, 방향, 배열에서의 위치 
		
		public Piece(int y, int x, int dir, int idx) {
			this.y = y;
			this.x= x;
			this.dir = dir;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][N]; // 칸의 색깔 0: 빈 칸 , 1: 빨간색, 2: 파란색 
		ArrayList<Piece>[][] board =  new ArrayList[N][N]; // 체스판 위의 말들을 담는 배열 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				board[i][j] = new ArrayList<Piece>();
			}
		}
		
		Piece[] ps = new Piece[K]; // 1번 ~ K번 말 
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			ps[i] = new Piece(y,x,dir,0);
			board[y][x].add(ps[i]);
		}

		int[] dy = { 0, 0, -1, 1 };
		int[] dx = { 1, -1, 0, 0 }; // 우 좌 상 하
		
		int turn = 1;
		boolean endGame = false;
		while (turn <= 1000) {
			for (int i=0; i<K; i++) { // 턴 시작 
				Piece curp = ps[i];
				int y = curp.y;
				int x = curp.x;
				int dir = curp.dir;
				int idx = curp.idx;
//				System.out.println((i+1)+"번째 말 y:"+ y+" x:"+ x+" dir:"+dir);
				
				ArrayList<Piece> temp = new ArrayList<>(); // 임시 배열  (다음 칸으로 이동 )
				ArrayList<Piece> stay = new ArrayList<>(); // 남는 배열  
				
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == '2') { // 범위를 벗어나거나 파란색 칸 
					
					// 방향 전환 
					if (dir == 0) curp.dir = 1;
					if (dir == 1) curp.dir = 0;
					if (dir == 2) curp.dir = 3;
					if (dir == 3) curp.dir = 2;
					
					ny = y + dy[curp.dir];
					nx = x + dx[curp.dir];
					
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == '2') continue;
					
					if (map[ny][nx] == '1' ) {
						
						for (int j = board[y][x].size()-1; j>= idx; j--) { // 거꾸로 임시 배열에 담기 
							temp.add(board[y][x].get(j));
						}
						
						for (int j=0; j<idx; j++) {
							stay.add(board[y][x].get(j));
						}
						
					} else if (map[ny][nx] == '0') { // 빈 칸 
						
						boolean flag = false;
						for (int j=0; j<board[y][x].size(); j++) {
							if (j==idx) flag = true;
							if (flag) temp.add(board[y][x].get(j));
							else stay.add(board[y][x].get(j));
						}
					}
					
				} else if (map[ny][nx] == '1') { // 빨간색 칸 
					
					for (int j = board[y][x].size()-1; j>= idx; j--) { // 거꾸로 임시 배열에 담기 
						temp.add(board[y][x].get(j));
					}
					
					for (int j=0; j<idx; j++) {
						stay.add(board[y][x].get(j));
					}
					
				} else if (map[ny][nx] == '0') { // 빈 칸 
					
					boolean flag = false;
					for (int j=0; j<board[y][x].size(); j++) {
						if (j==idx) flag = true;
						if (flag) temp.add(board[y][x].get(j));
						else stay.add(board[y][x].get(j));
					}
				}
				
				board[y][x] = stay;
				
				int nextSize = board[ny][nx].size();
				for (Piece p : temp) {
					p.idx = nextSize++;
					p.y = ny;
					p.x = nx;
					board[ny][nx].add(p);
				}
				
				if (board[ny][nx].size() >= 4) endGame = true;
			} // 턴 종료 
			if (endGame) break;
			turn++;
		}
		if (endGame) System.out.println(turn);
		else System.out.println(-1);

	}
}