package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805_나무자르기 {
	static int N;
	static long M;
	static long tree[];
	static long result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) {
			tree[n] = Integer.parseInt(st.nextToken());
		}
		if(N == 1) {
			System.out.println(tree[1] - M);
			return;
		}
		Arrays.sort(tree);
		dfs(N, N-1, 1);
		System.out.println(result);
	}
	static void dfs(int now, int next, long d) {
		long temp = (tree[now] - tree[next]) * d;
		if(M - temp < 0) {
			//나누어 떨어질 경우
			if(M % d == 0){
				long x = (M / d);
				result = tree[now] - x;
				return;
			}else {
				//안나누어 떨어질 경우
				long x = (M / d) + 1;
				result = tree[now] - x;
				return;
			}
		}else if(M - temp > 0){
			M -= temp;
			dfs(now-1, next-1, d+1);
		}else {
			result = tree[next];
		}
	}
}