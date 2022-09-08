package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10025 { // 게으른 백곰 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 얼음 양동이 갯수 
		int K = Integer.parseInt(st.nextToken()); // 좌 우 닿을 수 있는 거리 
		int[] ice = new int[1000001]; // 얼음 양동이 저장 일차원 배열 

		// 얼음 위치 표시 
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken()); // 얼음의 양 
			int x = Integer.parseInt(st.nextToken()); // x 좌표 
			ice[x] = g; // x좌표에 있는 얼음의 양 저장 
		}

		// 초기 K * 2 범위만큼 얼음 세기 
		int cnt = 0; // 양동이 카운트  
		int sumIce = 0; // K*2 범위 내 얼음의 합 
		int end = Math.min(K*2, 1000000); // K의 최댓값이 x축의 최대 범위보다 크다 
		for (int i=0; i<=end; i++) {
			if (ice[i] > 0) { // 얼음 양동이가 있으면 
				cnt++; // 얼음 양동이 카운트 
				sumIce += ice[i]; // 얼음의 합에 추가 
			}
		}

		// 투포인터로 최댓값 계산 
		int s = 0; // 왼쪽 끝 
		int e = K*2; // 오른쪽 끝 
		int ans = sumIce; // 얼음의 합 
		while (e<1000000) { // x좌표가 끝나기 전까지 
			if (cnt == N) break; // 모든 얼음 양동이를 찾으면 끝내자 
			sumIce += ice[++e]; // 다음 오른쪽 끝의 얼음의 양을 추가하고 
			sumIce -= ice[s++]; // 현재 왼쪽 끝의 얼음의 양을 빼고 다음 인덱스로 이동하자 
			ans = Math.max(ans, sumIce); // 얼음의 양 최댓값 구하기 
		}
		
		System.out.println(ans);
	}

}
