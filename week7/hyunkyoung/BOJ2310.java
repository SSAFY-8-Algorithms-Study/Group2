package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2310 { // 어드벤처 게임
	static int N;
	static Info[] list;
	static String result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(br.readLine()); // 방 수
			if(N == 0) break;
			
			list = new Info[N + 1];
			result = "No";
			
			for(int n = 1; n <= N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char type = st.nextToken().charAt(0);
				int cost = Integer.parseInt(st.nextToken());
				list[n] = new Info(type, cost);
				list[n].conn = new ArrayList<>();
				
				while(true) {
					int next = Integer.parseInt(st.nextToken());
					if(next == 0) break;
					
					list[n].conn.add(next);
				}

				list[n].visit = new boolean[list[n].conn.size() + 1];
			} // end input
			
			dfs(1, 0);
			System.out.println(result);
		}
	}
	
	static void dfs(int num, int money) {
		if(list[num].type == 'L') {
			if(money < list[num].cost) money = list[num].cost;
		} else if(list[num].type == 'T') {
			if(money >= list[num].cost) money -= list[num].cost;
			else {
				return;
			}
		}
		
		if(num == N) {
			result = "Yes";
			return;
		}

		for(int i = 0; i < list[num].conn.size(); i++) {
			if(result.equals("No") && !list[num].visit[i]) {
				list[num].visit[i] = true;
				dfs(list[num].conn.get(i), money);
			}
		}
	}
	
	static class Info {
		char type; int cost;
		ArrayList<Integer> conn;
		boolean[] visit;
		
		Info(char type, int cost) {
			this.type = type;
			this.cost = cost;
		}
	}
}
