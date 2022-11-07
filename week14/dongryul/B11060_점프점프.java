import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] D;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];

		D = new int[N];
		Arrays.fill(D, Integer.MAX_VALUE);
		ans = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		D[0] = 0;
		dfs(0);
		System.out.println(D[N-1] == Integer.MAX_VALUE ? -1 : D[N-1]);
	}
	static void dfs(int idx) {
		if(idx == N-1) {		//끝까지 왔남?
			ans = Math.min(ans, D[N-1]);
			return;
		}
		
		for(int i=1; i<=arr[idx]; i++) {
			if(idx + i >= N) break;		//범위 나가면
			if(D[idx + i] > D[idx] + 1) {	//DP
				D[idx + i] = D[idx] + 1;
				dfs(idx + i);
			}
			
		}
		
	}
}

