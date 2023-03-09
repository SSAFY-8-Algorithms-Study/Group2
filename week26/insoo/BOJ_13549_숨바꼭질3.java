package pending;
import java.io.*;
import java.util.*;
class BOJ_13549_숨바꼭질3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int size = 100000;
		
		Queue<Info> q = new ArrayDeque<>(); // 큐
		q.add(new Info(N, 0));

		boolean[] visited = new boolean[size+1]; // 좌표
		
		while(!q.isEmpty()) {
			Info po = q.poll();
            
			if(po.x == K) {
				System.out.print(po.cnt);
				return;
			}
            
			int xx1 = po.x * 2; // 큐에 추가
			if(xx1<=size && !visited[xx1]) { // 방문 검사
				visited[xx1] = true;
				q.add(new Info(xx1, po.cnt));
			}
			
			int xx2 = po.x - 1;
			if(xx2>=0 && !visited[xx2]) {
				visited[xx2] = true;
				q.add(new Info(xx2, po.cnt+1));
			}
			
			int xx3 = po.x + 1;
			if(xx3<=size && !visited[xx3]) {
				visited[xx3] = true;
				q.add(new Info(xx3, po.cnt+1));
			}
		}
	}
	
	static class Info {
		int x, cnt;
		Info(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
}