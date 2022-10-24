package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1043 { // 거짓말
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer>[] pList;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수
		
		Queue<Integer> tPeople = new ArrayDeque<>();
		adjList = new ArrayList[N + 1];
		pList = new ArrayList[M];
		visit = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			pList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int tCnt = Integer.parseInt(st.nextToken());
		if(tCnt != 0) {
			for(int i = 0; i < tCnt; i++) {
				int tNum = Integer.parseInt(st.nextToken());
				visit[tNum] = true;
				tPeople.add(tNum);
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pCnt = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			pList[i].add(idx);
			
			for(int j = 1; j < pCnt; j++) {
				int pNum = Integer.parseInt(st.nextToken());
				adjList[idx].add(pNum);
				adjList[pNum].add(idx);
				pList[i].add(pNum);
				idx = pNum;
			}
		} // end input
		
		int result = 0;
		bfs(tPeople);		
		
		for(int i = 0; i < M; i++) {
			boolean flag = true;
			for(int num : pList[i]) {
				if(visit[num]) {
					flag = false;
					break;
				}
			}
			
			if(flag) result++;
		}
		
		System.out.println(result);
	}
	
	static void bfs(Queue<Integer> queue) {
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			for(int n : adjList[num]) {
				if(!visit[n]) {
					queue.add(n);
					visit[n] = true;
				}
			}
		}
	}
}
