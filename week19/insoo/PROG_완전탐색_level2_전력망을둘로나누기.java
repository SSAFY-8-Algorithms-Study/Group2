package trying;

import java.util.ArrayList;
/*
 * 인접리스트
 * 자르는 전선 기준 (앞의 송전탑)과 (뒤의 송전탑)을 구별하여 연결을 구하는 접근
 */
public class PROG_완전탐색_level2_전력망을둘로나누기 {
	public static void main(String[] args) {
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		
		System.out.print(Solution(n, wires));
	}
	
	static int another;
	static boolean[] visit;
	static ArrayList<Integer>[] adj;
	
	static int Solution(int n, int[][] wires) {
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; adj[i++] = new ArrayList<>());
		
		getAdjList(wires); // 인접 리스트 메서드 호출
		
		int min = Integer.MAX_VALUE;
		
		for(int[] wire : wires) {
			visit = new boolean[n+1];
			another = wire[0]; // 자르는 전선 중 앞 송전탑 기록
			
			visit[wire[1]] = true; // 뒤 송전탑 기록
			getConnect(wire[1]); // 뒤 송전탑과 연결된 것들 확인
			
			min = Math.min(min, getGap(n)); // 송전탑 수의 차를 구하는 메서드 호출
		}
		
		return min;
	}
	
	static void getAdjList(int[][] wires) { // 인접 리스트 메서드
		for (int i = 0; i < wires.length; i++) {
			int[] el = wires[i];
			adj[el[0]].add(el[1]); // 양방향 연결
			adj[el[1]].add(el[0]);
		}
	}
	
	static void getConnect(int node) { // 송전탑 연결 확인
		for (int i = 0; i < adj[node].size(); i++) {
			int next = adj[node].get(i);
			if(next != another && !visit[next]) { // 앞 송전탑 연결 방지
				visit[next] = true; // 연결된 송전탑 기록
				getConnect(next);
			}
		}
	}
	
	static int getGap(int n) { // 송전탑 수의 차를 구하는 메서드
		int A = 0;
		for(boolean e : visit) if(e) A++;
		int B = n - A;
		
		return Math.abs(A-B);
	}
}