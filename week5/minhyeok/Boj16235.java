package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj16235 {
	
	static int N;
	static int M;
	static int K;
	static int[][] A; // 매년 추가되는 양분의 양
	static int[][] g; // 땅의 양분 상태 
	static ArrayList<Tree> arr; // r,c tree
	static ArrayList<Tree> copy; // r,c tree
	static int[] dy = {-1,-1,-1,0,0,1,1,1}; 
	static int[] dx = {-1,0,1,-1,1,-1,0,1}; 
	
	static class Tree implements Comparable<Tree>{
		int y;
		int x;
		int age;
		boolean isDead;
		
		public Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
			isDead = false;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅의 크기
		M = Integer.parseInt(st.nextToken()); // 초기 나무의 개수
		K = Integer.parseInt(st.nextToken()); // 카운트 해야할 년 수
		A = new int[N][N]; // 양분 2차원 배열
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		g = new int[N][N]; // 땅 2차원 배열 
		for (int i=0; i<N; i++) {
			Arrays.fill(g[i], 5); // 초기 양분은 5만큼 들어있다.
		}
		arr = new ArrayList<Tree>(); // 나무를 관리할  리스트
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 행
			int c = Integer.parseInt(st.nextToken()); // 열 
			int age = Integer.parseInt(st.nextToken()); // 나무의 나이
			Tree t = new Tree(r-1,c-1,age); // 나무 생성
			arr.add(t); // 나무 큐에 넣어 준다
		}
		
		for (int k=0; k<K; k++) {
			// Spring
			Collections.sort(arr);
			for (Tree t: arr) {
				int y = t.y;
				int x = t.x;
				int age = t.age;
				if (g[y][x] >= age) { // 양분이 충분하다
					g[y][x] -= age; // 양분을 먹는다 
					t.age++; // 나이 1 증가
				} else {
					t.isDead = true; // 양분이 부족하면 죽는다
				}
			} // end spring
			
			// Summer
			copy = new ArrayList<Tree>(); // 죽지 않은 나무 옮겨 담기 
			for (Tree t: arr) {
				if (t.isDead) {
					g[t.y][t.x] += t.age/2; // 죽은 나무는 양분으로 추가
				} else {
					copy.add(t);
				}
			} // end summer
			arr = copy; // 새로운 배열 갱신
			// Autumn
			copy = new ArrayList<Tree>(); // 새로 생긴 나무 옮겨 담기
			for (Tree t: arr) {
				copy.add(t);
				if (t.age % 5 == 0) { // 나무의 나이가 5의 배수이면 번식한다
					for (int d=0; d<8; d++) {
						int ny = t.y + dy[d];
						int nx = t.x + dx[d];
						if (0<=ny && ny<N && 0<= nx && nx<N) {
							Tree nT = new Tree(ny,nx,1);
							copy.add(nT);
						}
					}// end search
				}
			} // end autumn
			arr = copy; // 새로운 배열 갱신
			// Winter
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					g[i][j] += A[i][j];
				}
			} // end winter
		} // end K years
		System.out.println(arr.size());
	} // end main

}