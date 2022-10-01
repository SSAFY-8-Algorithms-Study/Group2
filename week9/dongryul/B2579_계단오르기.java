package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2579_계단오르기 {
	static int[] stair;
	static int N;
	static int max = 0;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stair = new int[N+1];
		arr = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		if(N <= 2) {
			int sum = 0;
			for(int i=1; i <=N; i++) {
				sum += stair[i];
			}
			System.out.println(sum);
			return;
		}
		bfs();
		System.out.println(max);
	}
	static void bfs() {
		
		Queue<Step> q = new LinkedList<>();
		q.add(new Step(0, 2, stair[2]));
		q.add(new Step(1, 2, stair[1] + stair[2]));
		q.add(new Step(1, 3, stair[1] + stair[3]));
		
		while(!q.isEmpty()) {
			Step now = q.poll();
			if(now.num == N) {
				//now.sum += stair[now.num];
				max = Math.max(now.sum, max);
			}
			
			if(now.num - now.before == 1) {
				if(now.num + 2 > N) {
					continue;
				}
				//한칸올라왔으면 두칸만 갈 수 있음
				if(arr[now.num + 2][1] < now.sum + stair[now.num + 2]) {
					arr[now.num + 2][1] = now.sum + stair[now.num + 2];
					q.add(new Step(now.num, now.num+2, arr[now.num + 2][1]));
				}
			}else {
				//두칸 올라왔으면 한칸 두칸 갈 수 있음.
				//일단 한칸 가
				
				if(now.num + 1 > N) {
					continue;
				}
				if(arr[now.num + 1][0] < now.sum + stair[now.num + 1]) {
					arr[now.num + 1][0] = now.sum + stair[now.num + 1];
					q.add(new Step(now.num, now.num+1, arr[now.num + 1][0]));
				}
				
				if(now.num + 2 > N) {
					continue;
				}
				//두칸도 가
				if(arr[now.num + 2][1] < now.sum + stair[now.num + 2]) {
					arr[now.num + 2][1] = now.sum + stair[now.num + 2];
					q.add(new Step(now.num, now.num+2, arr[now.num + 2][1]));
				}
			}
		}
	}
	static class Step{
		int before;
		int num;
		int sum;
		public Step(int before, int num, int sum) {
			this.before = before;
			this.num = num;
			this.sum = sum;
		}
		
		
	}
}
