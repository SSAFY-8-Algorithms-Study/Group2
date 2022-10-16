package boj;

import java.io.*;
import java.util.*;

public class Boj8982 { // 수족관 1

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] height = new int[40000]; // 천장 초기값 0
		int[] floor = new int[40000];
		int W = 0, H = 0;

		br.readLine(); // (0,0) 날리기
		int ans = 0;
		for (int i = 1; i < N - 1; i += 2) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			for (int x = c1; x < c2; x++) {
				floor[x] = r1;
				ans += r1;
			}
			if (i == N - 3) {
				W = c2;
				H = r2;
			}
		}
		br.readLine(); // (0,0) 날리기

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			st.nextToken();
			
			int level = r1; // 제거해야 할 물의 최소 깊이 (이 깊이 위의 물 제거) 
			int l = c1;
			while (l>=0) {
				
				if (level > floor[l]) level = floor[l]; // 깊이보다 바닥이 더 위에 있으면 바닥만큼 올려주기 
				
				if (level > height[l]) {
					ans -= (level - height[l]);
					height[l] = level;
				}
				l--;
			}
			
			level = r1;
			int r = c1+1;
			while (r<W) {
				
				if (level > floor[r]) level = floor[r];
				
				if (level > height[r]) {
					ans -= (level - height[r]);
					height[r] = level;
				}

				r++;
			}
		}
		System.out.println(ans);
	}

}