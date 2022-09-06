import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * BOJ 9372 Silver 4
 * 상근이의 여행
 */
public class BOJ_9372_상근이의여행 {
	static int min;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	static void btr(int from) { // 리스트 배열 중 방문하지 않은 요소를 시작점으로 재귀
		for (int i = 0; i < list[from].size(); i++) {
			int to = list[from].get(i);
			if(!visited[to]) {
				visited[to] = true;
				btr(to);
				min++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int ntc = 0; ntc < tc; ntc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가 수
			int M = Integer.parseInt(st.nextToken()); // 비행기 종류
			visited = new boolean[N+1];
			list = new ArrayList[N+1];
			min = 0;

			for (int i = 1; i <list.length ; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			visited[1] = true;
			btr(1);
			System.out.println(min);
		}
	}
}
