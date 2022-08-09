package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 2563 bronze 1
 * 색종이
 * 1. 색종이 개수 * 100을 초기 value로 잡는다.
 * 2. 색종이를 붙이며 좌표값에 +1을 한다.
 * 3. 좌표값이 1을 초과하면 value-1을 한다.
 */
public class BOJ2563 {
	static int[][] canvas;
	static int value = 0;
	
	static void attach(int x, int y, boolean bool) {
		// 범위 예외 처리
		if(x < 0 | x >= 100 | y < 0 | y >= 100) return;
		
		if(bool) {
			// 캔버스에 붙이는 좌표값+1
			canvas[x][y]++;
			if(canvas[x][y] > 1) {
				// 중복이면-1
				value--;
			}
		}
		else {
			// 10 * 10
			for (int xRange = 0; xRange < 10; xRange++) {
				for (int yRange = 0; yRange < 10; yRange++) {
					attach(x+xRange, y+yRange, true);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        canvas = new int[100][100];
    	value = 100 * tc;
    	
        for (int i = 0; i < tc; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
			
        	// 각 색종이 붙이기
        	attach(x, y, false);
		}
        System.out.print(value);
    }
}