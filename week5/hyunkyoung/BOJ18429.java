package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18429 { // 근손실
	static int N, K;
	static int[] kit;
	static boolean[] visit;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 기간 = 키트 수
		K = Integer.parseInt(st.nextToken()); // 하루 감소 중량
		kit = new int[N]; // 키트 중량 증가량
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			kit[n] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, 500);
		System.out.println(res);
	}
	
	static void perm(int cnt, int weight) {
		if(cnt == N) {
			res++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == false && weight - K + kit[i] >= 500) {
				visit[i] = true;
				perm(cnt + 1, weight - K + kit[i]);
				visit[i] = false;
			}
		}
	}
}
