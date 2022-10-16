package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B17143_낚시왕 {
	static int R, C, M;
	static Shark[][] map;
	static Shark[][] map2;
	static int[] di = {0, -1, 1, 0, 0};	// 1 up 2 down 3 right 4 left
	static int[] dj = {0, 0, 0, 1, -1};
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R+1][C+1];

		ans = 0;
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = new Shark(s,d,z);
		}
		
		for(int s=1; s<=C; s++) {
			print();
			//상어 잡아요~
			for(int i=1; i<=R; i++) {
				if(map[i][s] != null) {
					ans += map[i][s].z;	//잡은 상어 크기
					map[i][s] = null;	// 상어 사라져~
					break;
				}
			}
			//상어야 이동하자
			//상어 리스트 만들기
			map2 = new Shark[R+1][C+1];
			
			for(int i=1; i<=R; i++) {
				for(int j=1; j<=C; j++) {
					if(map[i][j] != null) {
						Shark now = map[i][j];
						
						int nexti = i + di[now.d] * now.s;
						int nextj = j + dj[now.d] * now.s;
						
						while(nexti > R || nexti < 1) {
							now.d = reverse(now.d);
							if(nexti > R) {
								nexti = R + ((R) - nexti);
							}
							if(nexti < 1) {
								nexti = 1 + (1 - nexti);
							}
						}
						
						while(nextj > C || nextj < 1) {
							now.d = reverse(now.d);
							if(nextj > C) {
								nextj = C + ((C) - nextj);
							}
							if(nextj < 1) {
								nextj = 1 + (1 - nextj);
							}
						}
						
						map[i][j] = null;
						//상어 갱신
						if(map2[nexti][nextj] == null || map2[nexti][nextj].z < now.z) {
							map2[nexti][nextj] = now;	
						}
					}
				}
			}
			//새로운 배열
			for(int i=1; i<=R; i++) {
				for(int j=1; j<=C; j++) {
					map[i][j] = map2[i][j];
				}
			}
		}
		System.out.println(ans);
	}
	static int reverse(int dir) {
		switch (dir) {
			case 1: return 2;
			case 2: return 1;
			case 3: return 4;
			case 4: return 3;
		}
		return 0;
	}
	static class Shark{
		int s;
		int d;
		int z;
		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}
	static void print() {
		System.out.println("-------------------");
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(map[i][j] == null) {System.out.print("0");}
				else {
					System.out.print(map[i][j].z + " ");
				}

			}
			System.out.println();
		}
	}
}
