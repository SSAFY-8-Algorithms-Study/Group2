import java.io.*;
import java.util.*;
class BOJ_17071_숨바꼭질5 {
	static int MAX = 500_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] able = new int[2][MAX + 1]; // 좌표별 홀수 짝수 / 0 짝수 1 홀수
		Arrays.fill(able[0], -1);
		Arrays.fill(able[1], -1);
		
		ArrayDeque<Info> q = new ArrayDeque<>();
		q.add(new Info(N, 0));
		able[0][N] = 0;
		
		while(!q.isEmpty()) { // 수빈 이동 BFS
			Info now = q.poll();
			int nextIdx = 0;
			int nextCnt = now.cnt + 1;
			
			for (int i = 0; i < 3; i++) {
				switch (i) {
				case 0: nextIdx = now.idx - 1; break;
				case 1: nextIdx = now.idx + 1; break;
				case 2: nextIdx = now.idx * 2; break;
				}
				if(0<=nextIdx && nextIdx<=MAX && able[nextCnt % 2][nextIdx] == -1) {
					able[nextCnt % 2][nextIdx] = nextCnt;
					q.add(new Info(nextIdx, nextCnt));
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int plus = 0;
        
		while(K <= MAX) { // 동생 이동
			if(able[plus % 2][K] <= plus && able[plus % 2][K] != -1) {
				min = Math.min(min, plus);
			}
			
			K += ++plus;
		}
		System.out.print(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static class Info {
		int idx, cnt;
		Info(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}