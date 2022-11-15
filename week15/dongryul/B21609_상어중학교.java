package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21609_상어중학교 {
	static int N, M;
	static int[][] map;
	static boolean[][] total_visit;
	static int max;
	static int max_rainbow;

	static int max_i;
	static int max_j;
	
	static int total_Score;
	
	static ArrayList<Point> remove_list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];

		
		for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
			 }
		}

		total_Score = 0;

		while(true) {
			max_i = -1;
			max_j = -1;
			
			max = 0;
			max_rainbow = 0;
			remove_list = new ArrayList<>();
			total_visit = new boolean[N][N];
			
			//1. 크기가 가장 큰 블록 그룹 찾기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] <= 0) continue;
					if(total_visit[i][j]) continue;
					findGroup(i, j, map[i][j]);
				}
			}
			// 기준 블록이 없다는 것은 끝
			if(max_i == -1 && max_j == -1) break;
			
//			System.out.println("max_i : " + max_i + ", max_j : " + max_j);
//			System.out.println(max);
			//2. 모든 블록을 제거한다.
			removeGroup();
			
			gravity();
			rotateArray();
			gravity();

		}
		System.out.println(total_Score);
	}
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static void findGroup(int i, int j, int normal) {
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> list = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Point(i, j));
		list.add(new Point(i, j));
		visited[i][j] = true;
		total_visit[i][j] = true;
		
		int size = 1;
		int rainbowCnt = 0;
		int kingBlocki = i, kingBlockj = j;	// 기준 블록
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int d=0;d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) continue;
				if(visited[nexti][nextj]) continue;
				if(map[nexti][nextj] < 0) continue;	// 검은색 블록
					
				if(map[nexti][nextj] == 0) {	 // 무지개 블록
					rainbowCnt++;
					size++;	 	// 그룹 사이즈
					visited[nexti][nextj] = true;
					q.add(new Point(nexti, nextj));
					list.add(new Point(nexti, nextj));
					
				}else if(map[nexti][nextj] == normal) { // 일반 블록 색이 같아야 함.
					size++;	 	// 그룹 사이즈
					visited[nexti][nextj] = true;
					q.add(new Point(nexti, nextj));
					list.add(new Point(nexti, nextj));
				}

				
			}
		}
		//그룹이 정해졌을 때, 기준 블록을 바꾼다.
		if(size < 2) return;	// 블록 갯수는 2보다 크거나 같아야 한다.
	
//		System.out.println("i = " + i);
//		System.out.println("j = " + j);
//		System.out.println("size = " + size);
//		System.out.println("rainbow = " + rainbowCnt);
		
		if(max < size) {
			//크기가 가장 큰 그룹 갱신
			max_i = kingBlocki;
			max_j = kingBlockj;
			max_rainbow = rainbowCnt;
			max = size;
			remove_list = list;
		}
		else if(max == size) {	//그러한 블록 그룹이 여러개 라면
			if(max_rainbow < rainbowCnt) { //무지개 블록
				//크기가 가장 큰 그룹 갱신
				max_i = kingBlocki;
				max_j = kingBlockj;
				max_rainbow = rainbowCnt;
				max = size;
				remove_list = list;
			}
			else if(max_rainbow == rainbowCnt) { // 또 같애..?
				if(max_i < kingBlocki) {	// 행이 가장 큰 것을..
					//크기가 가장 큰 그룹 갱신
					max_i = kingBlocki;
					max_j = kingBlockj;
					max_rainbow = rainbowCnt;
					max = size;
					remove_list = list;
				}else if(max_i == kingBlocki) {	//행이 똑같아?
					if(max_j < kingBlockj) {	// 찐막 - 열이 가장 큰 것
						//크기가 가장 큰 그룹 갱신
						max_i = kingBlocki;
						max_j = kingBlockj;
						max_rainbow = rainbowCnt;
						max = size;
						remove_list = list;
					}
				}
			}
		}//end 조건
		
	}//find
	static void removeGroup() {
		int cnt = remove_list.size();
		for(Point p : remove_list) {
			map[p.i][p.j] = -2;
		}
		total_Score += cnt * cnt;
	}
	static void rotateArray() {
		int[][] newArr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				newArr[(N-1) - j][i] = map[i][j];
			}
		}
		map = newArr;
	}
	static void gravity() {
		for(int j=0; j<N; j++) {
			int zeroCnt = 0;
			for(int i=N-1; i>=0; i--) {
				if(map[i][j] == -1) {
					zeroCnt = 0;
				}
				else if(map[i][j] == -2) {	// 빈 칸
					zeroCnt++;
				}
				else {
					int temp = map[i][j];
					map[i][j] = -2;	//빈칸 변경
					map[i + zeroCnt][j] = temp;	//내리기
				}
			}
		}
	}
	static void print(int[][] map) {
		System.out.println("--------------------------------");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}	
