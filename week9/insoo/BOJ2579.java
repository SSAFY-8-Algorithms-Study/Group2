package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
 * BOJ 2579 Silver 3
 * 계단 오르기
 */
public class BOJ_2579_계단오르기 {
	static class El {
		int idx, score;
		boolean fst, sec;
		El(int idx, int score, boolean fst, boolean sec) {
			this.idx = idx;
			this.score = score;
			this.fst = fst;
			this.sec = sec;
		}
	}
	static int N;
	static int[] stairs;
	static int[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stairs = new int[N+1];
		visited = new int[N+1][2][2];
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			stairs[i] = num;
		}

		System.out.print(goUp());
	}
	
	static int goUp() {
		PriorityQueue<El> q = new PriorityQueue<>((a,b)->
			a.idx == b.idx ? b.score - a.score : a.idx - b.idx);
		
		q.add(new El(0,0,false,false));
		
		while(!q.isEmpty()) {
			El el = q.poll();
			int idx = el.idx;
			int score = el.score;
			if(visited[idx][el.fst ? 1 : 0][el.sec ? 1 : 0] >= score && idx != 0) continue;
			visited[idx][el.fst ? 1 : 0][el.sec ? 1 : 0] = score;

			if(idx==N) return score;
			
			for (int i = 1; i <= 2; i++) {
				int next = idx + i;
				if(next > N) continue;
				
				if(i == 1) {
					if(el.fst && el.sec) continue;
					else if(el.fst)
						q.add(new El(next, score + stairs[next], true, true));
					else
						q.add(new El(next, score + stairs[next], true, el.sec));
				}
				else q.add(new El(next, score + stairs[next], true, false));
			}
		}
		return 0;
	}
}