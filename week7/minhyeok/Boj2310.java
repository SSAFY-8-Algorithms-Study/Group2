package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj2310 { // 어드벤처 게임 
	
	static int N;
	static ArrayList[] g;
	static char[] roomType;
	static int[] roomMoney;
	static boolean[] visited;
	static boolean isFin;
	
	static void dfs(int start, int myMoney) {
				
		if (start == N) { // 도착 
			isFin = true; // 끝 
			return;
		}
		
		for (int i=0; i<g[start].size(); i++) {
			int nextRoom = (int) g[start].get(i);
			if (isFin) return;

			// 아직 방문하지 않은 방 
			if (!visited[nextRoom]) {

				// 방 타입 별로 백트래킹 
				if (roomType[nextRoom] == 'T' && myMoney - roomMoney[nextRoom] >= 0) {
					visited[nextRoom] = true;
					dfs(nextRoom, myMoney - roomMoney[nextRoom]);
					visited[nextRoom] = false;
				} else if (roomType[nextRoom] == 'L') {
					visited[nextRoom] = true;
					if (myMoney < roomMoney[nextRoom]) {
						dfs(nextRoom,roomMoney[nextRoom]);		
					}  else {
						dfs(nextRoom, myMoney);
					}
					visited[nextRoom] = false;
				} else if (roomType[nextRoom] == 'E'){
					visited[nextRoom] = true;
					dfs(nextRoom,myMoney);
					visited[nextRoom] = false;
				}
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 정답 

		// 무한 루프 
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) break; // 탈출 조건
			
			g = new ArrayList[N+1]; // 그래프 
			roomType = new char[N+1]; // 방의 타입 / E, L ,T
			roomMoney = new int[N+1]; // 정해진 금액 
			visited = new boolean[N+1];
			
			for (int i=1; i<=N; i++) {
				g[i] = new ArrayList<Integer>(); // 연결 그래프 
				String[] str = br.readLine().split(" ");
				roomType[i] = str[0].charAt(0); // 방 타입 
				roomMoney[i] = Integer.parseInt(str[1]); // 돈 
				for (int j=2; j<str.length; j++) {
					int room = Integer.parseInt(str[j]); // 연결된 방 
					if (room == 0) break;
					g[i].add(room); // 연결된 방 추가 
				}
			}

			isFin = false;
			// 1번 방부터 시작 
			if (roomType[1] == 'T' && roomMoney[1] == 0) {
				dfs(1,0);
			} else if (roomType[1] == 'L') {
				dfs(1,roomMoney[1]);
			} else if (roomType[1] == 'E') {
				dfs(1,0);
			}

			if (isFin) sb.append("Yes"); // 도착 가능 
			else sb.append("No"); // 도착 불가 
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
