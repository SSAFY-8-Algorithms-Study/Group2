package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Boj15997 { // 승부 예측 

	static String[][] data;
	static HashMap<String, Integer> parse;
	static double[] ans = new double[4];
	
	static void dfs(int cnt, int[] score, double games) {
		
		if (cnt == 6) { // 6경기 후 종료 
			int top2Cnt = 0; // 상위 2팀 세기 
			// 최고 승점 (9점) 부터 다음 라운드 진출 2팀 뽑기
			for (int i=9; i>=0; i--) {
				if (top2Cnt >=2) break;
				ArrayList<Integer> sameScore = new ArrayList<Integer>(); // 승점이 같은 팀들 추가 
				for (int tIdx=0; tIdx<4; tIdx++) {
					if (i == score[tIdx]) {
						sameScore.add(tIdx); 
					}
				}
				
				// 다음 라운드 진출을 위해 남을 자리 수에 따라 로직 처리 
				for (int teamIdx: sameScore) {
					if (top2Cnt + sameScore.size() <= 2) {
						ans[teamIdx] += games;
					} else {
						ans[teamIdx] += (games / sameScore.size()) * (2-top2Cnt);
					}
				}
				top2Cnt += sameScore.size();
			}
			return;
		}
		
		String[] str = data[cnt]; // 1개의 경기 결과 데이터 
		String team1 = str[0]; // 첫번째팀 
		String team2 = str[1]; // 두번째팀 
		
		for (int i=2; i<5; i++) { // 승 무 패 확률 
			if (Double.parseDouble(str[i])>0) {
				double curGames = Double.parseDouble(str[i]);
				
				// 승, 무, 패 각각의 경우 
				if (i==2) {
					score[parse.get(team1)] += 3;
					dfs(cnt+1, score, games * curGames);
					score[parse.get(team1)] -= 3;
				} else if (i==3) {
					score[parse.get(team1)] += 1;
					score[parse.get(team2)] += 1;
					dfs(cnt+1,score, games * curGames);
					score[parse.get(team1)] -= 1;
					score[parse.get(team2)] -= 1;
				} else {
					score[parse.get(team2)] += 3;
					dfs(cnt+1,score, games * curGames);
					score[parse.get(team2)] -= 3;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] teams = br.readLine().split(" "); // 주어진 4팀 이름 
		parse = new HashMap<String,Integer>(); // 팀 이름 -> 팀 인덱스 
		for (int i=0; i<4; i++) {
			parse.put(teams[i], i);
		}
		data = new String[6][5]; // 6경기의 결과 승/무/패 확률 데이터 
		for (int i=0; i<6; i++) {
			data[i] = br.readLine().split(" ");
		}
		int[] score = new int[4]; // 4팀의 승점 
		double games = 1; // 경기 횟수 
		dfs(0,score,games);
		for (double a: ans) {
			System.out.println(a);
		}
	}

}

