package boj;

import java.util.Scanner;

public class Boj16992 {
	static int n;
	static int[] rom = {1,5,10,50};
	static boolean[] visited = new boolean[1001];
	static int ans = 0;
	static void repComb(int cnt, int start,int sum) {
		if (cnt==n) {
			if (!visited[sum]) {
				visited[sum]=true;
				ans++;
			}
			return;
		}
		for (int i=start;i<4;i++) {
			repComb(cnt+1,i,sum+rom[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		repComb(0,0,0);
		System.out.println(ans);
	}

}
