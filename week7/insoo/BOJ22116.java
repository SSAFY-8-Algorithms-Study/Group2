import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * BOJ 22116 Gold 4
 * 창영이와 퇴근
 */
public class BOJ_22116_창영이와퇴근 {
	static int N;
	static int[] xDir = {0, 1, 0, -1};
	static int[] yDir = {1, 0, -1, 0};
	static int[][] map, minSlope;
	
	static class Point {
		int x, y, s;
		Point(int x, int y, int s) {
			this.x = x; // 행
			this.y = y; // 열
			this.s = s; // 경사
		}
	}
	
	public static int navigate() {
		PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.s - b.s); // 최소 경사 우선 탐색
		pq.add(new Point(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Point po = pq.poll();
			
			if(po.x == N-1 && po.y == N-1) {
				return po.s;
			}
			
			for (int i = 0; i < 4; i++) {
				int xx = po.x +xDir[i];
				int yy = po.y +yDir[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<N) {
					int gap = Math.abs(map[po.x][po.y] - map[xx][yy]); // 경사 차
					int nowSlope = Math.max(po.s, gap); // 이동 전 좌표까지의 최소 경사와 비교
					
					if(nowSlope < minSlope[xx][yy]) { // 저장된 경사보다 현재가 최소 경사라면
						minSlope[xx][yy] = nowSlope; // 최소 경사 갱신
						pq.add(new Point(xx, yy, nowSlope)); // 이동한 좌표와 최소 경사 삽입
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 격자 크기

		minSlope = new int[N][N]; // 최소 경사 기록 배열
		for(int[] e : minSlope) Arrays.fill(e, Integer.MAX_VALUE);
		
		map = new int[N][N]; // 맵 입력
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		System.out.print(navigate());
	}
}