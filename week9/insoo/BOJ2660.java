package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * BOJ 2660 Gold 5
 * 회장뽑기
 */
public class BOJ_2660_회장뽑기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1) break;
			list[a].add(b);
			list[b].add(a);
		}
		
		int minStep = Integer.MAX_VALUE;
		ArrayList<Integer> hubo = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N+1];
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.add(new int[] {i, 0});
			visited[i] = true;
			int maxStep = 0;
			
			while(!q.isEmpty()) {
				int[] e = q.poll();
				int from = e[0];
				int step = e[1];
				
				if(maxStep < step) maxStep = step;
				
				for (int j = 0; j < list[from].size(); j++) {
					int to = list[from].get(j);
					
					if(visited[to]) continue;
					visited[to] = true;
					q.add(new int[] {to, step+1});
				}
			}
			if(maxStep <= minStep) {
				if(maxStep < minStep) {
					hubo = new ArrayList<>();
					minStep = maxStep;
				}
				hubo.add(i);
			}
		}
		System.out.println(minStep + " " + hubo.size());
		for(int e : hubo) System.out.print(e + " ");
	}
}