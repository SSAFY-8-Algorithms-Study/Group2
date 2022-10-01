package adj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2660_회장뽑기 {
	static int N;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] arr;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		adjList = new ArrayList[N+1];
		arr = new int[N+1];
		min = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		while(true) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			if(from == -1 && to == -1) {
				break;
			}
			adjList[from].add(to);
			adjList[to].add(from);
			
		}//end input
		boolean flag = true;
		for(int i=1; i<=N; i++) {
			
			if(adjList[i].size() == N - 1) {
				//모두와 친구면 점수 1
				arr[i] = 1;
				min = 1;
				flag = false;
				continue;
			}
			if(flag) {	// 모두랑 친구인 사람이 나오면 굳이 할 필요가 없음?
//				visited = new boolean[N+1];
//				dfs(i, 0);
				bfs(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(min == arr[i]) {
				count++;
				sb.append(i + " ");
			}
		}
		System.out.println(min + " " + count);
		System.out.println(sb.toString());
	}
	static void bfs(int start) {
		visited = new boolean[N+1];
		visited[start] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		int d=0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int now = q.poll();
				
				for(int next : adjList[now]) {
					if(!visited[next]) {
						q.add(next);
						visited[next] = true;
					}
				}
				
			}//end for
			d++;
		}//end while
		min = Math.min(min, d-1);
		arr[start] = d-1;
	}
	static void dfs(int num, int d) {
		//자기자신 방문체크
		visited[num] = true;
		
		for(int next : adjList[num]) {
			if(visited[next]) {
				dfs(next, d+1);
			}
		}
		min = Math.min(min, d);
		arr[num] = d;
	}
}
