package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1051 {
	
	static int ans = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // row
		int n = Integer.parseInt(st.nextToken()); // col
		
		int[][] arr = new int[m][n];
		for (int i=0;i<m;i++) {
			String str = br.readLine();
			for (int j=0;j<n;j++) {
				arr[i][j] = (int) str.charAt(j);
			}
		}
		
		int maxLen = Math.min(m, n); // max width of square
		for (int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int p = arr[i][j]; // one point of square
				for (int k=1;k<maxLen;k++) {
					if (i+k<m && j+k<n) {
						if(arr[i+k][j]==p && arr[i][j+k]==p && arr[i+k][j+k]==p) {
							ans = Math.max(ans, (k+1)*(k+1));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}
