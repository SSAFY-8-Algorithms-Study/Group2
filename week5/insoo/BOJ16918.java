import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * BOJ 16918 Silver 1
 * 봄버맨
 */
public class BOJ_16918_봄버맨 {
	static int R, C;
	static int[] xDir = { 0, 1, 0, -1 };
	static int[] yDir = { 1, 0, -1, 0 };
	static boolean[][] map, visited;
	static ArrayDeque<Point> q;

	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	// 완전 탐색이 아닌 다른 시도를 해보고 싶어서 폭탄 좌표 델타 탐색을 시도
	// 하나의 메서드로 해결하는 것을 시도하느라 우겨넣어서 좀 복잡함...
	// 완전 탐색에 비해 효율성은 좋음
	static void find(boolean isNumberFive) {
		boolean[][] temp = new boolean[R][C];
		
		int size = q.size();
		for (int k = 0; k < size; k++) {
			Point po = q.poll();
			
			if(!isNumberFive) q.add(new Point(po.x, po.y));
			else temp[po.x][po.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int xx = po.x + xDir[i];
				int yy = po.y + yDir[i];
				if(!isNumberFive) {
					if (xx >= 0 && xx < R && yy >= 0 && yy < C && false == map[xx][yy] && !visited[xx][yy]) {
						visited[xx][yy] = true;
						q.add(new Point(xx, yy));
						map[xx][yy] = !map[xx][yy];
					}
				}
				else {
					if (xx >= 0 && xx < R && yy >= 0 && yy < C) {
						if(map[xx][yy] == false) temp[po.x][po.y] = false;
					}
				}
			}
			if(!isNumberFive) map[po.x][po.y] = !map[po.x][po.y];
		}
		if(isNumberFive) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = temp[i][j];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer RCN = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(RCN.nextToken()); // 행
		C = Integer.parseInt(RCN.nextToken()); // 열
		int N = Integer.parseInt(RCN.nextToken()); // 몇 초 후
		map = new boolean[R][C];
		q = new ArrayDeque<>();
		visited = new boolean[R][C];
		char empty = '.';
		char bomb = 'O';

		for (int i = 0; i < R; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(N==1) {
					map[i][j] = chars[j] == '.' ? true : false;
				}
				else if (chars[j] == 'O') {
					q.add(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		if (N % 2 == 0 || N == 1);
		else if (N % 4 == 3)
			find(false);
		else {
			find(false);
			find(true);
			
			char temp = empty;
			empty = bomb;
			bomb = temp;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j] ? empty : bomb);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}