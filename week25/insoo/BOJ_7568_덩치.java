package algo;
import java.io.*;
import java.util.*;
class BOJ_7568_덩치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Info[] list = new Info[N];
		Info[] sorted = new Info[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			Info info = new Info(w,h);
			
			list[i] = info;
			sorted[i] = info;
		}
		// 몸무게로 1차 정렬, 키로 2차 정렬
		Arrays.sort(sorted, (a,b) -> a.w == b.w ? a.h - b.h : a.w - b.w);
		
		for(Info pick : list) {
			int cnt = 1;
			
			for (int i = N-1; i >= 0; i--) { // 역순으로 탐색
				if(sorted[i].w <= pick.w) break; // 몸무게 크면서 키도 큰 사람 찾기
				if(sorted[i].h <= pick.h) continue;
				cnt++;
			}
			sb.append(cnt + "\n");
		}
		
		System.out.print(sb);
	}
	
	static class Info {
		int w, h;
		Info(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
}