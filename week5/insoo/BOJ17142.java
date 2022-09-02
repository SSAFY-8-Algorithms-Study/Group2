import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * BOJ 17142 Gold 4
 * 연구소 3
 */
public class BOJ_17142_연구소3 {
	static int N, M;
	static int minTime;
	static int[] xDir = {0, 1, 0, -1};
	static int[] yDir = {1, 0, -1, 0};
	static int[][] map;
	static ArrayList<Virus> virusList;
	static Virus[] selected;
	
	static class Virus {
		int x, y, t;
		Virus(int x, int y, int t) {
			this.x = x; // x좌표
			this.y = y; // y좌표
			this.t = t; // 처리 시간
		}
	}
	
	static int bfs(Virus[] list) {
		int[][] copied = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copied[i], 0, N);
		}
		
		boolean[][] visited = new boolean[N][N];
		
		PriorityQueue<Virus> q = new PriorityQueue<>((a,b) -> a.t - b.t);
		for (int i = 0; i < list.length; i++) {
			q.add(list[i]); // 조합 선택된 요소들 큐에 추가
			visited[list[i].x][list[i].y] = true;
		}
		int time = 0;
		
		while(!q.isEmpty()) {
			Virus vrs = q.poll();
				
			for (int i = 0; i < 4; i++) {
				int xx = vrs.x + xDir[i];
				int yy = vrs.y + yDir[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<N && !visited[xx][yy]) {
					if(copied[xx][yy] == 0) { // 빈공간일 때
						visited[xx][yy] = true;
						copied[xx][yy] = 1;
						if(time < vrs.t+1) time = vrs.t+1; // 최대 처리 시간 구하기
						q.add(new Virus(xx, yy, vrs.t+1));
					}
					else if(copied[xx][yy] == 2) { // 비활성 폭탄일 때
						visited[xx][yy] = true;
						q.add(new Virus(xx, yy, vrs.t+1));
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(copied[i][j] == 0) return -1; // 바이러스를 모두 퍼뜨리지 못 한 경우
			}
		}
		return time;
	}
	
	static void comb(int start, int cnt) { // 조합 메서드
		if(cnt==M) {
			int time = bfs(selected);
			if(time == -1) return;
			minTime = Math.min(minTime, time); // 조합 중 최소 처리 시간 구하기
			return;
		}
		for (int i = start; i < virusList.size(); i++) {
			selected[cnt] = virusList.get(i);
			comb(i+1, cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer RCN = new StringTokenizer(br.readLine());
		N = Integer.parseInt(RCN.nextToken());
		M = Integer.parseInt(RCN.nextToken());
		minTime = Integer.MAX_VALUE;
		
		virusList = new ArrayList<>();
		selected = new Virus[M];

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v == 2) virusList.add(new Virus(i, j, 0));
			}
		}
		comb(0,0); // 조합 호출
		System.out.print(minTime == Integer.MAX_VALUE ? -1 : minTime);
	}
}