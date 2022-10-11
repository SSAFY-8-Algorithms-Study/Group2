package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj6987 { // 월드컵 
	static boolean isFin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] game = new int[6][3];
			boolean flag = false;
			for (int i = 0; i < 6; i++) {
				int w = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				if (w + d + l != 5) {
					flag = true;
					continue;
				}

				game[i] = new int[] { w, d, l };
			}
			if (flag)
				System.out.print(0 + " ");
			else {
				isFin = false;
				comb(0, 1, game);
				if (isFin) System.out.print(1+" ");
				else System.out.print(0+" ");
			}
		}

	}

	private static void comb(int start, int next, int[][] game) {
		if (isFin) return;
		

		if (start == 5 && next == 6) {
			for (int i=0; i<6; i++) {
				for (int j=0; j<3; j++) {
					if (game[i][j] != 0) {
						return;
					}
				}
			}
			isFin = true;
			return;
		}
		
		if (next == 6) {
			comb(start + 1, start + 2, game);
		}
		
		if (game[start][0] > 0 && game[next][2] > 0) { // win, lose
			game[start][0] -= 1;
			game[next][2] -= 1;
			comb(start, next + 1, game);
			game[start][0] += 1;
			game[next][2] += 1;
		}

		if (game[start][1] > 0 && game[next][1] > 0) { // draw
			game[start][1] -= 1;
			game[next][1] -= 1;
			comb(start, next + 1, game);
			game[start][1] += 1;
			game[next][1] += 1;
		}

		if (game[start][2] > 0 && game[next][0] > 0) { // lose, win
			game[start][2] -= 1;
			game[next][0] -= 1;
			comb(start, next + 1, game);
			game[start][2] += 1;
			game[next][0] += 1;
		}
	}

}
