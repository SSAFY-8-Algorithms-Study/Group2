package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11060 { // 점프 점프
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		for(int i = 0; i < N; i++) {
			if(dist[i] == Integer.MAX_VALUE) continue; // 가본적 없는 칸이면 continue

			for(int j = 1; j <= arr[i]; j++) { // 점프 점프
				if(i + j >= N) break; // 배열 범위 밖으로 나가면 break
				dist[i + j] = Math.min(dist[i + j], dist[i] + 1); // i번 칸을 통해서 가는게 더 빠른지 확인
			}
		}
		
		// System.out.println(Arrays.toString(dist));
		System.out.println(dist[N - 1] == Integer.MAX_VALUE? -1 : dist[N - 1]);
	}
}
