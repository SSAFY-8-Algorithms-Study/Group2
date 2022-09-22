package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 { // 효율적인 해킹
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
		M = Integer.parseInt(st.nextToken()); // 신뢰 관계
		list = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
		}
		
		result = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			hacking(i);
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}
		
		for(int i = 1; i <= N; i++) {
			if(result[i] == max) {
				sb.append(i).append(' ');
			}
		}
		
		System.out.println(sb);
	}
	
	static void hacking(int num) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];

		q.add(num);
		visit[num] = true;
		
		while(!q.isEmpty()) {
			int cNum = q.poll();
			
			for(int n : list[cNum]) {
				if(!visit[n]) {
					q.add(n);
					visit[n] = true;
					result[n] += 1;
				}
			}
		}
	}
}
