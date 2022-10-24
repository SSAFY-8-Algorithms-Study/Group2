package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14225 { // 부분수열의 합
	static int N;
	static int[] nums;
	static boolean[] sums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		int total = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			total += nums[i];
		}
		
		sums = new boolean[total + 2];
		findSum(0, 0);
		
		for(int i = 1; i <= total + 1; i++) {
			if(!sums[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void findSum(int idx, int sum) {
		if(idx == N) {
			sums[sum] = true;
			return;
		}
		
		findSum(idx + 1, sum + nums[idx]);
		findSum(idx + 1, sum);
	}
}
