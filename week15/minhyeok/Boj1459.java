package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1459 { // 걷기 

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 목적지 y좌표 
		int y = Integer.parseInt(st.nextToken()); // 목적지 x좌표 
		int w = Integer.parseInt(st.nextToken()); // 한 블록 가는데 걸리는 시간 
		int s = Integer.parseInt(st.nextToken()); // 대각선 가는데 걸리는 시간 
		long minTime = 0; // 최소 시간 
		// 1. 대각선으로 이동하기 
		if (Math.min(x, y) !=0) {
			long move = Math.min(x, y);
			minTime += Math.min(w*2, s) * move; // (-> + ^ vs /)
			x -= move;
			y -= move;
		}
		
		// 2. 수평 or 수직 이동 
		if (Math.max(x, y)>0) {
			long restMove = Math.max(x, y); // 남은 이동 거리 
			minTime += Math.min(2*w, 2*s) * (restMove/2); // 2만큼 이동하는 두 가지 방법 (그냥 가기 vs 대각선으로 가기) 중 최소 이동 시간으로 이동 후 거리 1 이 남아있으면 1만큼 가기  
			minTime += w*(restMove%2);
		}
		System.out.println(minTime);
	}

}
