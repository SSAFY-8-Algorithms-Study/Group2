package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6987 { // 월드컵
	static int[][] score;
	static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int c = 0; c < 4; c++) {
			score = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());

			int total = 0;
			for(int k = 0; k < 6; k++) {
				for(int s = 0; s < 3; s++) {
					score[k][s] = Integer.parseInt(st.nextToken());
					total += score[k][s];
				}
			}
			
			flag = false;
			if(total == 30) {
				check(0);
			}
			
			int result = (flag == false) ? 0 : 1;
			sb.append(result + " ");
		}
		
		System.out.println(sb);
	}
	
	static void check(int game) {
		if(flag) return;
		
		if(game == 15) {
			flag = true;
			return;
		}

		int t1 = team1[game];
		int t2 = team2[game];

		// t1 승, t2 패
		if(score[t1][0] > 0 && score[t2][2] > 0) {
			score[t1][0]--;
			score[t2][2]--;
			check(game + 1);
			score[t1][0]++;
			score[t2][2]++;
		}
		
		// t1 패, t2 승
		if(score[t1][2] > 0 && score[t2][0] > 0) {
			score[t1][2]--;
			score[t2][0]--;
			check(game + 1);
			score[t1][2]++;
			score[t2][0]++;
		}
		
		// 무승부
		if(score[t1][1] > 0 && score[t2][1] > 0) {
			score[t1][1]--;
			score[t2][1]--;
			check(game + 1);
			score[t1][1]++;
			score[t2][1]++;
		}
	}
}
