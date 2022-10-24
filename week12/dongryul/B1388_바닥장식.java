package bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1388_바닥장식 {
	static int N, M;
	static char[][] map;
	static int total = 0;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					dfs(i, j, map[i][j]);
					total++;
				}
			}
		}
		System.out.println(total);
	}
	static void dfs(int i, int j, char shape) {
		int nexti = 0;
		int nextj = 0;
		if(shape == '-') {	//옆으로 가보고
			nexti = i + 0;
			nextj = j + 1;
			if(nextj >= M) return;
		}else {				//아래로 가볼것이여
			nexti = i + 1;
			nextj = j + 0;
			if(nexti >= N) return;
		}
		
		//만약 같은 문양
		if(shape == map[nexti][nextj]) {	
			visited[nexti][nextj] = true;	//방문체크
			dfs(nexti, nextj, shape);	//그 다음 연결된 문양으로 가
		}else {
			return;
		}
	}
}
