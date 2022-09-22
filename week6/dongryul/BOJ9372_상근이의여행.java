package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9372상근이의여행 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();	// N개의 국가
			int M = sc.nextInt();	// 비행기의 종류 M
			boolean[] visited = new boolean[N+1];	// 1번 국가부터 N번국가까지 visited
			
			LinkedList<Integer>[] adjList = new LinkedList[N+1];
			for(int i=1; i<=N; i++) {	//adjList 초기화
				adjList[i] = new LinkedList<Integer>();
			}
			for(int m=0; m<M; m++) {
				int from =  sc.nextInt();	//이 나라에서
				int to = sc.nextInt();	//이 나라로 이동
				
				adjList[from].add(to);
				adjList[to].add(from);
			}
			
			Queue<Integer> q = new LinkedList<>();
			q.add(1);
			visited[1] = true;
			
			int count=0;
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int n : adjList[now]) {
					if(!visited[n]) {
						q.add(n);
						visited[n] = true;
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
