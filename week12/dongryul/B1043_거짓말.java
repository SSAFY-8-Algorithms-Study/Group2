package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1043_거짓말 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 사람 수 N
		int M = Integer.parseInt(st.nextToken());	// 파티 수 M
		
		ArrayDeque<Integer>[] adjList = new ArrayDeque[101];	// 1~50 사람 51~100 파티
		for(int i=1; i<101; i++) {
			adjList[i] = new ArrayDeque<>();
		}
		
		//두번째 줄 입력
		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());	// 진실 아는 사람 수
		if(P == 0) {
			System.out.println(M);
			return;
		}
		
		int[] knowPeople = new int[P];	//진실을 알아??
		for(int p=0; p<P; p++) {
			knowPeople[p] = Integer.parseInt(st.nextToken());
		}
		
		for(int m=1; m<=M; m++) {	//파티 정보
			st = new StringTokenizer(br.readLine());
			int peopleCnt = Integer.parseInt(st.nextToken());
			for(int p=0; p<peopleCnt; p++) {
				int people = Integer.parseInt(st.nextToken());	// 파티 참가하는 사람 번호
				adjList[m + 50].add(people);
				adjList[people].add(m + 50);
			}
		}
		//System.out.println(Arrays.toString(knowPeople));
		
		boolean[] visited = new boolean[101];
		//진실 아는 사람이면 전파 해야지
		Queue<Integer> q = new LinkedList<>();
		for(int num : knowPeople) {
			q.add(num);
		}
		
		while(!q.isEmpty()) {	//진실을 아는사람 꼬리를 물고 그사람이 가는 파티는 true처리
			int now = q.poll();
			visited[now] = true;
			
			for(int next : adjList[now]) {
				if(!visited[next]) {
					q.add(next);
				}
			}
		}
		
		int cnt = 0;
		
		for(int i=51; i<=100; i++) {	// 파티 중 true인 곳은 과장된 얘기 금지.
			if(visited[i]) {
				cnt++;
			}
		}
		
		System.out.println(M - cnt);
	}
}
