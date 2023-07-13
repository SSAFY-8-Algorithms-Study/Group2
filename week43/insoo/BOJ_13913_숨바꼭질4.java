import java.io.*;
import java.util.*;
class BOJ_13913_숨바꼭질4_4 {
	static int N, MAX = 100_000;
	static int[] fromList, printList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K <= N) {
			method(K);
			return;
		}
		
		boolean[] visit = new boolean[MAX + 1];
		fromList = new int[MAX + 1];
		
		ArrayDeque<Info> q = new ArrayDeque<>();
		q.add(new Info(N, 0));
		
		while(!q.isEmpty()) {
			Info now = q.poll();
			
			if(now.idx == K) {
				printList = new int[now.cnt + 1];
				DFS(now.idx, now.cnt);
				
				System.out.println(now.cnt);
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				int nextIdx = now.idx;
				
				switch (i) {
				case 0: nextIdx -= 1; break;
				case 1: nextIdx += 1; break;
				case 2: nextIdx *= 2; break;
				}
				
				if(0<=nextIdx && nextIdx<=MAX && !visit[nextIdx]) {
					visit[nextIdx] = true;
					q.add(new Info(nextIdx, now.cnt+1));
					fromList[nextIdx] = now.idx;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int e : printList) sb.append(e + " ");
		System.out.print(sb);
	}
	
	static void DFS(int idx, int cnt) {
		printList[cnt] = idx;
		
		if(idx != N) DFS(fromList[idx], cnt-1);
	}
	
	static void method(int k) {
		StringBuilder sb = new StringBuilder();
		sb.append((N-k) + "\n");
		for (int i = N; k<=i; i--) sb.append(i + " ");
		System.out.print(sb);
	}
	
	static class Info {
		int idx, cnt;
		Info(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}