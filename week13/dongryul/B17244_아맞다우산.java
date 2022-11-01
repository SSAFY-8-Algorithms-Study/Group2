import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17244_아맞다우산 {
	static int C, R;
	static char[][] map;
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int index;
	static int[][] adjMatrix;
	static int min;
	static int start, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		ArrayList<Point> nodeList = new ArrayList<>(); 
		index = 1;
		min = Integer.MAX_VALUE;
		for(int i=0; i<R; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				char c = arr[j];
				if(c != '.' && c != '#') {
					if(c == 'S') {		//시작 인덱스
						start = index;
					}else if(c == 'E') {	// 끝 인덱스
						end = index;
					}
					
					map[i][j] = (char) ((index++) + '0');	// 인덱스를 맵에 표시
					nodeList.add(new Point(i,j));
				}else {
					map[i][j] = arr[j];
				}
			}
		}
		
		
		adjMatrix = new int[index][index];
		
		for(int i=0; i<nodeList.size(); i++) {
			Queue<Point> q = new LinkedList<>();
			boolean[][] visited = new boolean[R][C];
			Point start = nodeList.get(i);
			q.add(start);
			visited[start.i][start.j] = true;
			int dist = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				for(int s=0; s < size; s++) {
					Point now = q.poll();
					
					for(int d=0; d<4; d++) {
						int nexti = now.i + di[d];
						int nextj = now.j + dj[d];
						
						if(nexti < 0 || nexti >= R || nextj < 0 || nextj >= C) continue;
						
						if(visited[nexti][nextj]) continue;
						
						if(map[nexti][nextj] != '#') {
							q.add(new Point(nexti, nextj));
							visited[nexti][nextj] = true;
							
							if(map[nexti][nextj] != '.') {	// 물건, 스타트 ,도착지
								adjMatrix[i + 1][map[nexti][nextj] - '0'] = dist + 1;
							}
						}
					}
				}
				dist++;
			}
			
		}
		
		//재귀..?
		dfs(start, 0, new boolean[index], 0);	// 시작점에서 시작
		
		System.out.println(min);
	}
	static void dfs(int idx, int sum, boolean[] visited, int cnt) {
		if(cnt == index-3) {	// 인덱스 - 3 해야 물건 갯수
			int total = sum + adjMatrix[idx][end];
			min = Math.min(total, min);
			return;
		}
		
		
		for(int i=1; i<index; i++) {
			if(i == start || i == end) continue;
			if(visited[i]) continue;
			visited[i] = true;
			dfs(i, sum + adjMatrix[idx][i], visited, cnt + 1);
			visited[i] = false;
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
