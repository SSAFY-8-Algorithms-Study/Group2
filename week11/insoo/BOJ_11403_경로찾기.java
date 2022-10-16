import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * BOJ 11403 Silver 1
 * 경로 찾기
 */
public class BOJ_11403_경로찾기 {
	static int N;
	static int[][] map;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		list = new ArrayList[N];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int marked = Integer.parseInt(st.nextToken());
				if(marked == 1) {
					map[i][j] = marked;
					list[i].add(j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			getPath(i, i);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			} sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void getPath(int V, int origin) {
		if(visited[V]) return;
		visited[V] = true;
		
		for (int i = 0; i < list[V].size(); i++) {
			int found = list[V].get(i);
			map[origin][found] = 1;
			getPath(found, origin);
		}
	}
}