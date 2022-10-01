package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 2805 Silver 2
 * 이분탐색 실패
 */
public class BOJ_2805_나무자르기 {
	static int M;
	static int[] list;
	static long answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, list[i]);
		}

		visited = new boolean[max+1];
		int nextD = max/2;
		binarySearch(max - (max/2), nextD%2==0? nextD/2 : (nextD/2)+1);
		System.out.print(answer);
	}
	
	static void binarySearch(int h, int d) {
		if(visited[h]) return;
		visited[h] = true;
		long sum = 0;
		
		for (int i = 0; i < list.length; i++) {
			if(list[i] - h > 0) sum += list[i] - h;
			
			if(sum > M && d != 0) {
				answer = Math.max(answer, h);
				
				binarySearch(h+d, d%2==0 || d==1 ? d/2 : (d/2));
				return;
			}
		}
		
		if((d == 0 || sum == M) && sum >= M) answer = Math.max(answer, h);
		else if(sum < M) binarySearch(h-d, d%2==0 || d==1 ? d/2 : (d/2)+1);
	}
}