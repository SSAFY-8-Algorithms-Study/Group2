package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18429 {
	static int N; // N일 
	static int K; // 근손실 
	static int[] kit; // 운동 키트 
	static boolean[] visited; // 순열 방문 검사 
	static int[] selected; // 선택한 운동 키트 순열 
	static int ans;
	
	static void perm (int cnt) {
		if (cnt == N) {
			int weight = 500; // 처음 중량 
			for (int i=0; i<N; i++) { // N일 동안 검사 
				weight -= K; // 매일 감소하는 중량 
				weight += kit[selected[i]]; // i일차에 선택된 키트 사용 
				if (weight < 500) return; // 500 미만으로 내려가면 안됨 
			}
			ans++;
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				selected[cnt] = i;
				visited[i] = true;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kit = new int[N]; // n개의 운동 키트 
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		selected = new int[N];
		perm(0);
		System.out.println(ans);
	}

}
