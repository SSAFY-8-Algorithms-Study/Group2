package week25.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 7568 : 덩치*/
public class BOJ7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dung = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dung[i][0] = Integer.parseInt(st.nextToken());
			dung[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] rank = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (dung[i][0] < dung[j][0] && dung[i][1] < dung[j][1]) {
						rank[i]++;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(rank[i] + 1).append(" ");
		}
		System.out.println(sb);
	}

}
