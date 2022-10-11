package trying;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 틀림
 * 반례 모르겠음
 * 백트래킹으로 다시 풀어야 함
 */
public class BOJ_6987_월드컵_2 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();
		for (int ntc = 0; ntc < 1; ntc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] list = new int[6][3];
			int[] drawList = new int[6];
			
			boolean possible = true;
			int sumWin = 0;
			int sumLoose = 0;
			
			for (int nTeam = 0; nTeam < 6; nTeam++) {
				int sumScore = 0;
				for (int nScore = 0; nScore < 3; nScore++) {
					int score = Integer.parseInt(st.nextToken());
					sumScore += score;
					
					list[nTeam][nScore] = score;
					
					if (nScore == 0) sumWin += score;
					else if(nScore == 1) {
						drawList[nTeam] = score;
					}
					else sumLoose += score;
				}
				
				if (sumScore != 5) possible = false;
			}
			
				if (sumWin != sumLoose) possible = false;
			
			while(possible) {
				int maxWin = 0;
				for (int i = 0; i < 6; i++) {
					maxWin = Math.max(maxWin, list[i][0]);
				}
				
				if(maxWin == 0) break;
				
				for (int i = 0; i < 6; i++) {
					Arrays.sort(list,(a,b) -> a[2] == b[2] ? b[0] - a[0] : b[2] - a[2]);
				
					if(list[i][0] == maxWin) {
						for (int j = 0; j < 6; j++) {
							if(i != j && list[j][2] != 0) {
								list[i][0]--;
								list[j][2]--;
								if(list[i][0] == 0) break;
							}
						}
						if(list[i][0] != 0) {
							possible = false;
							break;
						}
					}
				}
			}

			for (int i = 0; i < 6; i++) {
				int cntDraw = 0;
				for (int j = 0; j < 6; j++) {
					if(drawList[j] != 0 && i != j) cntDraw++;
				}
				if(cntDraw < drawList[i]) {
					possible = false;
					break;
				}
			}

			sb.append((possible ? 1 : 0) + " ");
		}
		System.out.print(sb);
	}
}