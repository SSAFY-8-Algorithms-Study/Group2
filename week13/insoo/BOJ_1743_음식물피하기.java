package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int K = Integer.parseInt(st.nextToken()); // 쓰레기 수
		
		int[][] map = new int[N][M];
		
		ArrayDeque<int[]> stack = new ArrayDeque<>(); // 스택
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			map[r][c] = 1;
			stack.push(new int[] {r, c, 1});
		}
		
		int answer = 0;
		int sum = 0;
		
		while(!stack.isEmpty()) {
			int[] e = stack.pop();
			int r = e[0];
			int c = e[1];
			int cnt = e[2];
			
			if(map[r][c] == 2) continue;

			if(cnt == 1) sum = 1; // 다른 쓰레기 탐색 시 쓰레기 크기 초기화
			else if(cnt > 1) sum++;
			
			answer = Math.max(answer, sum);
			
			map[r][c] = 2;

			for (int i = 0; i < 4; i++) {
				int nr = r + new int[] {0, 1, 0, -1}[i];
				int nc = c + new int[] {1, 0, -1, 0}[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] == 1) {
					cnt++;
					stack.push(new int[] {nr, nc, cnt+1}); // 헤더에 넣어 연속해서 탐색
				}
			}
		}
		System.out.print(answer);
	}
}