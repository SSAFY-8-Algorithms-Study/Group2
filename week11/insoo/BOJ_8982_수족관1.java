import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * BOJ 8982 Gold 3
 * 수족관 1
 * 1. 가로를 인덱스로 가지는 수족관 깊이 배열을 구한다. map
 * 2. 가로별 채워진 물을 나타내는 배열을 구한다. hList
 * 3. 구멍 깊이가 얕은 순부터 오른쪽과 왼쪽을 따로 탐색해 hList의 값을 바꿔준다.
 */
public class BOJ_8982_수족관1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 꼭지점 수
		
		int[][] mapList = new int[N][2]; // 수족관 형태 구하기
		int C = 0;
		int R = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mapList[i][0] = Integer.parseInt(st.nextToken());
			mapList[i][1] = Integer.parseInt(st.nextToken());
			R = Math.max(C, mapList[i][0]); // 최대 세로줄
			C = Math.max(R, mapList[i][1]); // 최대 가로줄
		}
		
		int[] map = new int[R+1]; // 가로별 수족관 깊이 배열
		int idx = 0;
		int height = 0;
		for(int[] e : mapList) {
			int from = e[0];
			int to = e[1];
			
			if(idx == from) height = to;
			else {
				height = to;
				for (int i = idx; i < from; i++) {
					map[i+1] = height;
				}
				idx = from;
			}
		}
		
		int[] hList = new int[R+1]; // 가로별 채워진 물 배열
		System.arraycopy(map, 0, hList, 0, R+1);
		
		int K = Integer.parseInt(br.readLine()); // 구멍 수
		Hole[] holeList = new Hole[K];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			holeList[i] = new Hole(a,b,c,d);
		}
		Arrays.sort(holeList, (a,b) -> a.b - b.b); // 구멍 깊이 얕은 순부터
		
		for (int i = 0; i < holeList.length; i++) {
			Hole hole = holeList[i];
			int from = hole.a;
			int h = hole.b;
			
			for (int j = from+1; j <= C; j++) { // 오른쪽 탐색
				if(map[j] < h) h = map[j];
				if(hList[j] == map[j] - h) break;
				hList[j] = map[j] - h;
			}
			
			h = hole.b;

			for (int j = from; j >= 0; j--) { // 왼쪽 탐색
				if(map[j] < h) h = map[j];
				if(hList[j] == map[j] - h) break;
				hList[j] = map[j] - h;
			}
		}

		int answer = 0;
		for(int e : hList) answer += e;
		System.out.print(answer);
	}
	
	static class Hole {
		int a, b, c, d;
		Hole(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}
}