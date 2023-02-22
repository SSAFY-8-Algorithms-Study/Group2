import java.util.ArrayDeque;

public class PROG_GRAPH_leve3_순위 {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		System.out.print(Solution(n, results));
	}
	
	static ArrayDeque<Integer>[] fromList, toList;
	static boolean[] visit;
	
	static int Solution(int n, int[][] results) {
		fromList = new ArrayDeque[n+1]; // 단방향 리스트
		toList = new ArrayDeque[n+1];
		for (int i = 0; i <= n; fromList[i++] = new ArrayDeque<>());
		for (int i = 0; i <= n; toList[i++] = new ArrayDeque<>());
		
		for(int[] el : results) {
			fromList[el[0]].add(el[1]);
			toList[el[1]].add(el[0]);
		}
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			visit = new boolean[n+1];
			visit[i] = true;
			
			int A = DFS(i, true); // 지는 경우 DFS
			int B = DFS(i, false); // 이기는 경우 DFS
			
			System.out.println(A + " " + B);
			System.out.println("");
			
			if(A + B == n-1) cnt++;
		}
		
		return cnt;
	}
	
	static int DFS(int n, boolean isFrom) {
		int sum = 0;
		
		System.out.println(n);
		
		for(int next : isFrom ? fromList[n] : toList[n]) { // 인접 리스트
			if(visit[next]) continue;
			visit[next] = true;
			
			sum += DFS(next, isFrom) + 1; // 인접 리스트 DFS
		}
		
		return sum;
	}
}