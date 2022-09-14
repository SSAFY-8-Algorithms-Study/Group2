package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B15997_승부예측2 {
	static ArrayList<Team> teams = new ArrayList<>();
	static ArrayList<Team> score = new ArrayList<>();
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			String team = st.nextToken();
			score.add(new Team(team, 0));
			teams.add(new Team(team, 0));
		}
		
		for(int i=0; i<6; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			String team1 = st.nextToken();
			String team2 = st.nextToken();
			double W = Double.parseDouble(st.nextToken());
			double D = Double.parseDouble(st.nextToken());
			double L = Double.parseDouble(st.nextToken());
			
			if(W == 1.0) {	// 무조건 이김
				for(Team t : teams) {
					if(t.name.equals(team1)) {
						t.score += 3;
					}
				}
				
			}else if(D == 1.0) {	// 무조건 비김
				for(Team t : teams) {
					if(t.name.equals(team1)) {
						t.score += 1;
					}else if(t.name.equals(team2)) {
						t.score += 1;
					}
				}
				
			}else if(L == 1.0) {	// 무조건 짐
				for(Team t : teams) {
					if(t.name.equals(team2)) {
						t.score += 3;
					}
				}
				
			}else {
				list.add(s);
			}
		} // end for
		dfs(0);
		double sum = 0.0;
		for(Team t : score) {
			sum += t.score;
		}
		for(Team t : score) {
			System.out.printf("%.10f\n",(double)t.score / sum);
		}
		
	}

	static void dfs(int idx) {
		if(idx == list.size()) {
			Collections.sort(teams);
			Team tt1 = teams.get(0);
			Team tt2 = teams.get(1);
			Team tt3 = teams.get(2);
			for(Team t : teams) {
				System.out.println(t.toString());
			}
			if(tt1.score == tt2.score) {
				for(Team t : score) {
					if(t.name.equals(tt1.name)) {
						t.score += 2;
					}
				}
				for(Team t : score) {
					if(t.name.equals(tt2.name)) {
						t.score += 2;
					}
				}
			}else {
				for(Team t : score) {
					if(t.name.equals(tt1.name)) {
						t.score += 2;
					}
				}
				if(tt2.score == tt3.score) {
					for(Team t : score) {
						if(t.name.equals(tt2.name)) {
							t.score += 1;
						}
					}
					for(Team t : score) {
						if(t.name.equals(tt3.name)) {
							t.score += 1;
						}
					}
				}else {
					for(Team t : score) {
						if(t.name.equals(tt2.name)) {
							t.score += 2;
						}
					}
				}
			}
			
			return;
		}
		String s = list.get(idx);
		StringTokenizer st = new StringTokenizer(s);
		String t1 = st.nextToken();
		String t2 = st.nextToken();
		double W = Double.parseDouble(st.nextToken());
		double D = Double.parseDouble(st.nextToken());
		double L = Double.parseDouble(st.nextToken());
		
		Team team1 = null;
		Team team2 = null;
		for(Team t : teams) {
			if(t.name.equals(t1)) {
				team1 = t;
			}
		}
		for(Team t : teams) {
			if(t.name.equals(t2)) {
				team2 = t;
			}
		}
		if(W == 0) { // 0 0.5 0.5
			team2.score += 3;
			dfs(idx+1);
			team2.score -= 3;
			
			team1.score += 1;
			team2.score += 1;
			dfs(idx+1);
		}else if(D == 0) {	// 0.5 0 0.5
			team1.score += 3;
			dfs(idx+1);
			team1.score -= 3;
			
			team2.score += 3;
			dfs(idx+1);
			team2.score -= 3;

		}else if(L == 0) {	// 0.5 0.5 0
			team1.score += 3;
			dfs(idx+1);
			team1.score -= 3;
			
			team1.score += 1;
			team2.score += 1;
			dfs(idx+1);
		}else {
			// t1 이 이기는 경우
			team1.score += 3;
			dfs(idx+1);
			team1.score -= 3;
			
			// t1가 지는 경우
			team2.score += 3;
			dfs(idx+1);
			team2.score -= 3;
			
			// 비기는 경우
			team1.score += 1;
			team2.score += 1;
			dfs(idx+1);
		}
	}
	static class Team implements Comparable<Team>{
		String name;
		int score;
		
		public Team(String name, int score) {
			this.name = name;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Team [name=" + name + ", score=" + score + "]";
		}

		@Override
		public int compareTo(Team o) {
			return o.score - this.score;
		}
		
	}
}
