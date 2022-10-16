package adj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11403_경로찾기 {
	static ArrayList<Integer>[] adjList;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					adjList[i].add(j);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// i -> j로 갈 수 있니?
				System.out.print(bfs(i, j) + " ");
			}
			System.out.println();
		}
		
	}
	static int bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : adjList[now]) {
				if(!visited[next]) {
					if(next == end) {
						return 1;
					}
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return 0;
	}
}
