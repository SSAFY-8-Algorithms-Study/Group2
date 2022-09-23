import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
	static int N;
	static int cnt = 0;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[n][j] = Integer.parseInt(st.nextToken());
			}
		}// end Input
		dfs(0,1,'w');	// 0,1 가로로 시작
		System.out.println(cnt);
		
	}
	static void dfs(int i, int j, char d) {
		if(i == N-1 && j == N-1) {
			cnt++;
			return;
		}
		
		if(d == 'w') {	// 지금 가는 곳이 가로면??
			//가로로 갈 수 있어
			if(j + 1 < N && map[i][j + 1] == 0) {
				dfs(i, j+1, 'w');
			}
			
			//대각선으로 갈 수 있어
			if(i+1 < N && j+1 < N && map[i][j + 1] == 0 && map[i + 1][j + 1] == 0 && map[i + 1][j] == 0) {
				dfs(i+1, j+1, 'c');
			}
		}else if(d == 'h') {	//지금 가는 곳이 세로이면?
			//세로로 갈 수 있어
			if(i + 1 < N && map[i + 1][j] == 0) {
				dfs(i + 1, j, 'h');
			}
			
			//대각선으로 갈 수 있어
			if(i+1 < N && j+1 < N && map[i][j + 1] == 0 && map[i + 1][j + 1] == 0 && map[i + 1][j] == 0) {
				dfs(i+1, j+1, 'c');
			}
		}else {	//대각선이면?
			//가로로 갈 수 있어
			if(j + 1 < N && map[i][j + 1] == 0) {
				dfs(i, j+1, 'w');
			}
			//세로로 갈 수 있어
			if(i + 1 < N && map[i + 1][j] == 0) {
				dfs(i + 1, j, 'h');
			}
			//대각선으로 갈 수 있어
			if(i+1 < N && j+1 < N && map[i][j + 1] == 0 && map[i + 1][j + 1] == 0 && map[i + 1][j] == 0) {
				dfs(i+1, j+1, 'c');
			}
		}
	}
	static class Pipe {
		int i;
		int j;
		char d;	// width height cross
		
		public Pipe(int i, int j, char d) {

			this.i = i;
			this.j = j;
			this.d = d;
		}
		
	}
}
