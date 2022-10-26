package adj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14267_회사문화1 {
	static int N, M;
	static int[] relation;
	static int[] cost;
	static int[] value;
	static ArrayDeque<Point>[] adjList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		relation = new int[N+1];
		value = new int[N+1];
		adjList = new ArrayDeque[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayDeque<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {	// 직속 상사 번호
			int boss = Integer.parseInt(st.nextToken());
			if(boss == -1) continue;
			adjList[boss].add(new Point(i, 0));
		}
		cost = new int[N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());	//직원 (employee)
			int c = Integer.parseInt(st.nextToken());	//비용 (cost)
			cost[e] = c;
		
		}
		
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(1, cost[1]));	// 사장의 칭찬 정도
		
		while(!q.isEmpty()) {
			Point now = q.poll();
//			value[now.n] += now.w;	//각자의 칭찬 수치
			
			for(Point next : adjList[now.n]) {
							//	직속부하 | 상사의 수치 | 칭찬받는 수치
				value[next.n] = value[now.n] + cost[next.n];
				q.add(new Point(next.n, value[next.n]));
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(value[i] + " ");
		}
	}
	static class Point{
		int n;
		int w;
		public Point(int n, int w) {
			this.n = n;
			this.w = w;
		}
		
	}
}
