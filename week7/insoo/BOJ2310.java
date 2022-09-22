import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * BOJ 2310 Gold 5
 * 어드벤처 게임
 * 재방문 가능한 알고리즘
 */
public class BOJ_2310_어드벤처게임_s3 {
	static int N;
	static boolean canArrive;
	static boolean[][] visited;
	static Info[] rooms;
	static ArrayList<Integer>[] numsOfRoom;
	
	static class Info {
		char t;
		int m;
		Info(char t, int m) {
			this.t = t; // 방 타입
			this.m = m; // 정해놓은 금액
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N = Integer.parseInt(br.readLine()); // 미로의 방 수
			if(N == 0) break;
			rooms = new Info[N];
			canArrive = false;
			
			numsOfRoom = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				numsOfRoom[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char type = st.nextToken().charAt(0);
				int needMoney = Integer.parseInt(st.nextToken());
				rooms[i] = new Info(type, needMoney); // 방 정보
				
				while(true) {
					int numRoom = Integer.parseInt(st.nextToken());
					if(numRoom == 0) break;
					numsOfRoom[i].add(numRoom-1); // 방별 번호들
				}
			}
			visited = new boolean[N][501];
			navigate(0, 0); // 1번 방, 소지금 0 출발
			
			sb.append((canArrive ? "Yes" : "No") + "\n");
		}
		System.out.print(sb);
	}
	
	static void navigate(int idxRoom, int pocket) {
		Info room = rooms[idxRoom];
		
		if(room.t == 'L') { // 레프리콘이 있는 방
			if(pocket < room.m) pocket = room.m;
		}
		else if(room.t == 'T') { // 트롤이 있는 방
			if(pocket < room.m) return;
			pocket -= room.m;
		}

		if(idxRoom == N-1) { // N번 방 도착
			canArrive = true;
			return;
		}
		
		for (int i = 0; i < numsOfRoom[idxRoom].size(); i++) { // 문 번호로 탐색
			int nextRoom = numsOfRoom[idxRoom].get(i);
			if(nextRoom == idxRoom) continue; // 현재와 같은 인덱스 가지 치기
			if(visited[nextRoom][pocket]) continue; // 이전과 같은 소지금을 가지고 재방문 불가

			visited[nextRoom][pocket] = true; // 방 번호와 소지금 기록
			navigate(nextRoom, pocket); // 재귀
		}
	}
}