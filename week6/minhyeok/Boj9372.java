package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj9372 { // 상근이의 여행

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		for (int t=0; t<T; t++) { // t번 반복 예정이다 
			StringTokenizer st = new StringTokenizer(br.readLine()); // N, M 
			int N = Integer.parseInt(st.nextToken()); // 나라 개수 
			int M = Integer.parseInt(st.nextToken()); // 간선 개수 
			
			ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(); // 그래프 
			for (int i=0; i<N+1; i++) {
				g.add(new ArrayList<Integer>()); // 그래프 초기화 해주기 
			}
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine()); // from, to 
				int a = Integer.parseInt(st.nextToken()); // from 
				int b = Integer.parseInt(st.nextToken()); // to 
				
				// 양방향 연결 
				g.get(a).add(b); 
				g.get(b).add(a);
			}
			System.out.println(N-1); // ?? 생각해보니 무조건 연결그래프에 최소 간선이면 N-1 .. ?
		}
	}
}