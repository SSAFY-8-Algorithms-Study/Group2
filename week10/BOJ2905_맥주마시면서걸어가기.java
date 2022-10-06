package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2905_맥주마시면서걸어가기2 {
	static int N;
	static Point home;
	static Point rockFe;
	static Point[] store;
	static boolean[] visited;
	static String ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			store = new Point[N];
			visited = new boolean[N];
			ans = "sad";
			
			//상근이네 집
			home = new Point(sc.nextInt(), sc.nextInt());
			
			// 편의점
			for(int i=0; i<N; i++) {
				store[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			
			// 펜타포트 락 페스티벌
			rockFe = new Point(sc.nextInt(), sc.nextInt());
			
			Queue<Point> q = new LinkedList<>();
			q.add(home);
			
			while(!q.isEmpty()) {
				Point now = q.poll();
				
				// 락 페 거리 되는지 검사
				if(check(now, rockFe)) {
					ans = "happy";
					break;
				}
				
				for(int i=0; i<N; i++) {
					Point next = store[i];
					if(!visited[i]) {		// 방문하지 않은 곳이라면
						if(check(now, next)) {		//거리가 되야지
							q.add(new Point(store[i].i, store[i].j));
							visited[i] = true;
						}
					}
				}
			}
			System.out.println(ans);
		}
	
	}
	static boolean check(Point p1, Point p2) {
		if(Math.abs(p1.i - p2.i) + Math.abs(p1.j - p2.j) <= 1000) {
			return true;
		}
		return false;
	}
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
