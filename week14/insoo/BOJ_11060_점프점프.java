import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 11060 Silver 2
 * 점프 점프
 * DP로 하는 거보다 효율적일 거 같아서
 */
public class BOJ_11060_점프점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		int idx = 0;
		int cnt = 0;
		while(idx < N) {
			int nowValue = arr[idx];
			if(nowValue == 0 || idx == N-1) break; // 점프를 못 하거나, 끝에 도달한다면
			
			int nextIdx = 0;
			int max = 0; // 범위 중 최대값 저장
			cnt++;
			
			if(nowValue + idx >= N-1) {
				idx = N-1;
				break;
			}
			
			for (int i = 1; i <= nowValue; i++) {
				int next = idx + i + arr[idx+i];
				if(next >= N-1) { // 범위 넘어가는 점프 시
					System.out.print(cnt+1);
					return;
				}
				if(next >= max) {
					max = next;
					nextIdx = idx+i;
				}
			}
			idx = nextIdx;
		}
		System.out.print(idx == N-1 ? cnt : -1);
	}
}