import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * BOJ 17143 Gold 2
 * 낚시왕
 */
public class BOJ_17143_낚시왕 {
	static int R, C;
	static int[] xDir = {0, -1, 1, 0, 0};
	static int[] yDir = {0, 0, 0, 1, -1};
	static int[][][] map;
	static ArrayDeque<Info> pq;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		pq = new ArrayDeque<>();
		
		pq.add(new Info(0,1,-1,2,0,0)); //  낚시꾼

		map = new int[R+1][C+1][C+2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향 1 위 2 아래 3 우 4 좌
			int z = Integer.parseInt(st.nextToken()); // 크기
			
			pq.add(new Info(r,c,s,d,z,0)); // 상어
			map[r][c][0] = z;
		}
		
		System.out.print(bfs());
	}
	
	static int bfs() {
		while(!pq.isEmpty()) {
			Info e = pq.poll();
			int r = e.r;
			int c = e.c;
			int s = e.s;
			int d = e.d;
			int z = e.z;
			int sec = e.sec;
			
			if(c == C+1) return z;
			
			if(s == -1) { // 낚시꾼
				while(r < R && map[r][c][sec] == 0) r++;
				
				if(map[r][c][sec] != 0) {
					z += map[r][c][sec]; // 가까운 상어 잡음
					map[r][c][sec] = 0; // 잡은 상어 삭제
				}
				
				pq.add(new Info(0, c+1, -1, 2, z, sec+1));
				
			} else {
				if(map[r][c][sec] != z) continue;
				
				int ss = 0;
				if(d==3 || d==4) {
					ss = s % (C + C - 2);
				} else {
					ss = s % (R + R - 2);
				}
				
				while(ss-- > 0) {
					if((r==1 && d==1) || (c==C && d==3)) d++;
					else if((c==1 && d==4) || (r==R && d==2)) d--;
					r += xDir[d];
					c += yDir[d];
				}
				pq.add(new Info(r, c, s, d, z, sec+1));
				map[r][c][sec+1] = Math.max(map[r][c][sec+1], z);
			}
		}
		return 0;
	}
	
	static class Info {
		int r, c, s, d, z, sec;
		Info(int r, int c, int s, int d, int z, int sec) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.sec = sec; // 초 움직임
		}
	}
}