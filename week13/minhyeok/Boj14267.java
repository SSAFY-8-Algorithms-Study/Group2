package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14267 { // 회사 문화 1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 회사 직원 수 
		int M = Integer.parseInt(st.nextToken()); // 칭찬의 횟수 
		
		int[] boss = new int[N+1]; // 직속 상사 
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			boss[i] = Integer.parseInt(st.nextToken());
		}
		boss[1] = 0; // 사장 칭찬 0 
		
		long[] score = new long[N+1]; // 칭찬 저장 
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 직원 번호 
			int s = Integer.parseInt(st.nextToken()); // 칭찬 
			score[n] += s;
		}
		
		StringBuilder sb = new StringBuilder(); // 정답 출력 
		for (int i=1; i<=N; i++) {
			score[i] += score[boss[i]]; // i번 직원은 직속 상사의 점수를 누적해 받는다. 
			sb.append(score[i]+" ");
		}
		
		System.out.println(sb);
	}

}
