package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2206 {
	
	static int N;
	static int M;
	static char[][] g;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][][] visited; // 3-Dimension-array
	static PriorityQueue<Element> pq = new PriorityQueue<Element>(); // Priority Queue
	
	static void bfs() {
		
		while (pq.size()>0) {
			Element e = pq.poll();
			int cnt = e.cnt;
			int y = e.y;
			int x = e.x;
			int crush = e.crush;
			if (y==N-1 && x==M-1) {
				System.out.println(cnt);
				return;
			}
			
			for (int t=0;t<4;t++) {
				int ny = y+dy[t];
				int nx = x+dx[t];
				if (0<=ny && ny<N && 0<=nx && nx<M) {
					if (!visited[crush][ny][nx] && g[ny][nx]=='0') { // Go (Not Visited Yet and Not Wall)
						visited[crush][ny][nx] = true;
						pq.add(new Element(cnt+1,ny,nx,crush));
					}
					if (crush==1 && g[ny][nx]=='1') { // Crush Wall (Possible to Crush (Only One time) and It's Wall)
						visited[crush-1][ny][nx]=true; // Move to the Another Dimension (1->0, Impossible to Crush)
						pq.add(new Element (cnt+1,ny,nx,crush-1));
					}
				}
			}
		}
		System.out.println(-1);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new char[N][M];
		visited = new boolean[2][N][M]; // If visited[1][?][?] -> Possible to Crush Wall, Else visited[0][?][?] -> Impossible to Crush Wall
		for (int i=0;i<N;i++) {
			g[i] = br.readLine().toCharArray();
		}
		pq.add(new Element(1,0,0,1));
		visited[1][0][0] = true; // Start From (0,0)
		bfs();
	}
}

class Element implements Comparable<Element>{
	public int cnt;
	public int y;
	public int x;
	public int crush;
	
	public Element(int cnt, int y, int x, int crush) {
		this.cnt = cnt;
		this.y = y;
		this.x = x;
		this.crush = crush;
	}
	
	@Override
	public int compareTo(Element o) {
		// TODO Auto-generated method stub
		return this.cnt - o.cnt;
	}
	
}