package week25.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* BOJ 8979 : 올림픽 */
public class BOJ8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] medal = new int[n][4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			medal[i][0] = Integer.parseInt(st.nextToken());	// 국가
			medal[i][1] = Integer.parseInt(st.nextToken());
			medal[i][2] = Integer.parseInt(st.nextToken());
			medal[i][3] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(medal, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					if (o1[2] == o2[2]) return o2[3] - o1[3];					
					else return o2[2] - o1[2];	
				}
				else return o2[1] - o1[1];
			}
		});
		
		int[] rank = new int[n];
		int rankNum = 1;
		rank[0] = rankNum;
		
		for (int i = 1; i < medal.length; i++) {
			if (medal[i][1] == medal[i-1][1] && medal[i][2] == medal[i-1][2] && medal[i][3] == medal[i-1][3]) {
				rank[i] = rankNum;
			}
			else {
				rankNum = i + 1;
				rank[i] = rankNum;
			}
		}
		
		for (int i = 0; i < medal.length; i++) {
			if (medal[i][0] == k) {
				System.out.println(rank[i]);
			}
		}
	}
}