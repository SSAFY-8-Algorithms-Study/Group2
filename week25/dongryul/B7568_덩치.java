package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7568_덩치 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] persons = new int[N+1][2];
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			persons[n][0] = w;
			persons[n][1] = h;
		}
		

		for(int n=1; n<=N; n++) {
			int cnt = 0;
			for(int o=1; o<=N; o++) {
				if(n==o) continue;
				if(persons[n][0] < persons[o][0] && persons[n][1] < persons[o][1]) {
					cnt++;
				}
			}
			sb.append((cnt+1) + " ");
		}
		System.out.println(sb.toString());
	}
}
