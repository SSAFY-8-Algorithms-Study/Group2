package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B18428_감시피하기 {
	static int N;
	static char[][] map;
	static Point[] wall = new Point[3];
	static String ans = "NO";
	static ArrayList<Point> list = new ArrayList<>();
	static ArrayList<Point> teacher = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'X') {
					list.add(new Point(i,j));
				}
				if(map[i][j] == 'T') {
					teacher.add(new Point(i,j));
				}
			}
		}
		comb(0,0);
		System.out.println(ans);
	}
	static char[][] copy;
	static void comb(int idx, int cnt) {
		if(cnt == 3) {
			copy = deepcopy(map);
			// 3개의 장애물 세우기
			for(int i=0; i<3; i++) {
				copy[wall[i].i][wall[i].j] = 'O';
			}
			//print(copy);
			//선생님으로 부터 걸리는 학생 있는지 확인하기
			for(Point t : teacher) {
				for(int d=0; d<4; d++) {
					if(!check(t, d)) {
						//System.out.println("NO");
						return;
					}
				}
			}
			//System.out.println("YES");
			ans = "YES";
			return;
		}
		
		if(idx == list.size()) {
			return;
		}
		
		wall[cnt] = list.get(idx);
		comb(idx+1, cnt+1);
		comb(idx+1, cnt);
	}
	static char[][] deepcopy(char[][] origin) {
		char[][] copy = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static boolean check(Point now, int d) {
		int nowi = now.i;
		int nowj = now.j;
		
		while(true) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];
			
			if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) {
				break;
			}
			if(copy[nexti][nextj] == 'O' || copy[nexti][nextj] == 'T') {
				break;
			}
			if(copy[nexti][nextj] == 'S') {
				return false;
			}
			nowi = nexti;
			nowj = nextj;
		}
		return true;
	}
	static void print(char[][] map) {
		System.out.println("------------------------------");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class Point{
		int i;
		int j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}
