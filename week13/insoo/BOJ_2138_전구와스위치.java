package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138_전구와스위치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] current = new boolean[2][N];
		char[] currentLine = br.readLine().toCharArray();
		for (int i = 0; i < currentLine.length; i++) {
			if(currentLine[i] == '1') {
					for (int j = 0; j < 2; j++) { // 2차원으로 전구 상태 두 개를 만듬
					current[j][i] = true; // 현재 전구 상태
				}
			}
		}
		
		current[1][0] = !current[1][0]; // 하나는 0 인덱스 스위치를 눌러 0, 1을 뒤집은 상태
		current[1][1] = !current[1][1];
		
		boolean[] target = new boolean[N];
		char[] targetLine = br.readLine().toCharArray();
		for (int i = 0; i < targetLine.length; i++) {
			if(targetLine[i] == '1') target[i] = true; // 목표 전구 상태
		}
		
		int[] cnt = new int[2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				if(current[j][i] != target[i]) {
					if(i == N-1) { // 마지막 인덱스가 다르다면 -1
						cnt[j] = -1;
						continue;
					}
					
					for (int k = 0; k < 3; k++) { // 현재 인덱스가 다르다면 현재 +1 인덱스의 스위치를 누른다.
						if(i+k < N) current[j][i+k] = !current[j][i+k];
					}
					cnt[j]++;
				}
			}
		}
		
		if(cnt[0] != -1 && cnt[1] != -1) System.out.print(Math.min(cnt[0], cnt[1]+1));
		else if(cnt[0] != -1) System.out.print(cnt[0]);
		else if(cnt[1] != -1) System.out.print(cnt[1]+1);
		else System.out.print(-1);
	}
}