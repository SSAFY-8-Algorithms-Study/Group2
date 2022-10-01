package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2805 { // 나무 자르기 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		long min = 0;
		long max = 0;
		for (int i=0; i<N; i++) {
			int t = Integer.parseInt(st.nextToken());
			trees[i] = t;
			
			if (t > max) max=t;
		}
		
		
		long ans = 0;
		while (min <= max) { // 이분 탐색 
			
			long m = (long) (min+max) / 2; // 절단기 높이 
			
			long total = 0; // 가져갈 수 있는 나무 길이 
			for (int i=0; i<N; i++) {
				if (trees[i]-m >= 0) {
					total += trees[i] - m; // 나무 자르기 
				}
			}
			
			if (total == M) {
				ans = m;
				break;
				
			} else if (total < M){
				max = m-1;
			} else {
				ans = m; // 가져갈 수 있는 나무의 길이가 M 이상일 때 절단기의 높이 저장 
				min = m+1;
			}
			
			
		}
		System.out.println(ans);
	}

}
