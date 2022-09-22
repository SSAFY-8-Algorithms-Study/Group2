import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * BOJ 1325 Silver 1
 * 효율적인 해킹
 */
public class BOJ_1325_효율적인해킹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = 0;
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				list[A].add(B);
			}
		}	
		
		int[] cntList = new int[N+1];

		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N+1];
			visited[i] = true;
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int from = q.poll();
				
				for(int to : list[from]) {
					if(visited[to]) continue;
					if(from == to) continue;
					visited[to] = true;
					q.add(to);
					cntList[to]++;
				}
			}
			
		}
		
		for (int i = 1; i < cntList.length; i++) {
			max = max > cntList[i] ? max : cntList[i];
		}
		
		for (int i = 1; i < cntList.length; i++) {
			if(max == cntList[i]) sb.append(i + " ");
		}
		
		System.out.print(sb);
	}
}