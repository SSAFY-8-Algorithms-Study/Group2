package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16235 { // 나무 재테크
	static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 땅 크기
		int M = Integer.parseInt(st.nextToken()); // 나무 개수
		int K = Integer.parseInt(st.nextToken()); // 기간
		
		int[][] map = new int[N][N]; // 땅 배열
		int[][] food = new int[N][N]; // 추가 양분 배열
		LinkedList<Tree> tree = new LinkedList<>(); // 나무 리스트
		Queue<Tree> dTree = new ArrayDeque<>(); // 양분될 나무 리스트
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(map[i], 5);			
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			tree.add(new Tree(x - 1, y - 1, z));
		} // end input
		
		Collections.sort(tree);
		
		for(int k = 0; k < K; k++) {
			// 봄
			ArrayList<Tree> aTree = new ArrayList<>();			
			while(!tree.isEmpty()) {
				Tree t = tree.poll();
				if(map[t.x][t.y] >= t.age) {
					map[t.x][t.y] -= t.age;
					aTree.add(new Tree(t.x, t.y, t.age + 1));
				} else {
					dTree.add(new Tree(t.x, t.y, t.age));
				}
			}
			
			tree.addAll(aTree);
			
			// 여름
			while(!dTree.isEmpty()) {
				Tree t = dTree.poll();
				map[t.x][t.y] += t.age / 2;
			}
			
			// 가을
			aTree = new ArrayList<>();
			for(Tree t : tree) {
				if(t.age % 5 == 0) {
					for(int d = 0; d < 8; d++) {
						int ni = t.x + di[d];
						int nj = t.y + dj[d];
						
						if(0 <= ni && ni < N && 0 <= nj && nj < N) {
							aTree.add(new Tree(ni, nj, 1));
						}
					}
				}
			}
			
			tree.addAll(0, aTree);
			
			// 겨울
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] += food[i][j];
				}
			}
		}
		
		System.out.println(tree.size());
	}
	
	static class Tree implements Comparable<Tree> {
		int x, y, age;
		
		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return o.age - this.age;
		}
	}
}
