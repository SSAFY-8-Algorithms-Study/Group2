package adj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1956_운동 {
	static int V, E;
	static int[][] adjMatrix;
	static int[][] D;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjMatrix = new int[V+1][V+1];
		D = new int[V+1][V+1];
		
		for(int i=1; i<=V; i++) {
			Arrays.fill(D[i], 10000000);
		}
		//input
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			D[from][to] = weight;
		}
		
		for(int k=1; k<=V; k++) {
			for(int i=1; i<=V; i++) {
				if(k == i) continue;
				for(int j=1; j<=V; j++) {
					if(k == j) continue;
					if(i == j) continue;
					D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i == j) continue;
				// i->j + j -> i
				if(D[i][j] != 10000000 && D[j][i] != 10000000) {
					min = Math.min(min, D[i][j] + D[j][i]);
				}
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}
