package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1059 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()); // split 보다 4ms 단축 
		int[] arr = new int[L];
		for (int i=0;i<L;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 1. Sort
		int n = Integer.parseInt(br.readLine());
		
		int lLimit = 0; // left limit
		int rLimit = arr[L-1]; // right limit
		
		for (int i=0; i<arr.length;i++) {
			if (arr[i]<=n) {
				lLimit=arr[i];
			}
			if (arr[i]>=n) {
				rLimit = arr[i];
				break;
			}
		}
	
		int cnt = 0; // answer
		for (int i=1;rLimit-i>=n;i++) { 
			int r = rLimit-i;	// right point
			for (int j=1;r-j>lLimit;j++) {
				int l = r-j; // left point
				if (n>=l) {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}

}
