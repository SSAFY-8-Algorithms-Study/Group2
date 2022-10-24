package boj;

import java.io.*;
import java.util.*;

public class Boj14225 { // 부분수열의 합 
	static boolean[] ans; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		ans = new boolean[2000001]; // 정답을 체크할 배열 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,arr); // 인덱스, 누적합, 배열 
		for (int i=1; i<=2000000; i++) {
			if (!ans[i]) {
				System.out.println(i);
				break;
			}
		}
	}
	private static void dfs(int start, int sum, int[] arr) {
		int N = arr.length;
		if (start == N) {
			ans[sum] = true;
			return;
		}
		
		dfs(start+1,sum+arr[start],arr);
		dfs(start+1,sum,arr);
	}

}
