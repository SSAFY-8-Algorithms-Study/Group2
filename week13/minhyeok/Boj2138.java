package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2138 { // 전구와 스위치

	static int N;
	static int ans = Integer.MAX_VALUE;
	static char[] cur;
	static char[] target;

	private static void toggle(int i) { // i-1, i, i+1 범위 안의 전구 상태 변화 
		if (i - 1 >= 0) // 왼쪽에 전구가 있다 
			cur[i - 1] = (cur[i - 1] == '1') ? '0' : '1';
		cur[i] = (cur[i] == '1') ? '0' : '1'; // 가운데 전구 
		if (i + 1 < N) // 오른쪽 전구가 있다. 
			cur[i + 1] = (cur[i + 1] == '1') ? '0' : '1';

	}
	
	private static void dfs(int i, int cnt) { // 현재 전구 인덱스, 토글 횟수 
		if (i == N) { // 끝까지 왔을 때 
			// 끝에 두 자리 상태 확인 
			if (target[N-2] == cur[N-2] && target[N-1] == cur[N-1]) ans = Math.min(ans, cnt);
			return;
		}

		if (i - 1 >= 0) { // 왼쪽의 전구가 있을 때 같은 상태 ? PASS : TOGGLE
			if (target[i - 1] == cur[i - 1])
				dfs(i + 1, cnt); // 그냥 넘어가기 
			else { // 다르면 왼쪽 전구에 맞춰주기 
				toggle(i);
				dfs(i + 1, cnt + 1);
				toggle(i);

			}
		} else { // 왼쪽의 전구가 없는 상태일 때 TOGGLE 과 PASS 둘 다 해보기 
			toggle(i);
			dfs(i + 1, cnt + 1);
			toggle(i);
			dfs(i+1,cnt);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 전구 개수
		cur = br.readLine().toCharArray();
		target = br.readLine().toCharArray();
		dfs(0, 0); // 현재 전구, 누른 횟수 -> 백트래킹 
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

}
