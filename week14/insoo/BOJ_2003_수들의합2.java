import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ Silver 4
 * 수들의 합 2
 */
public class BOJ_2003_수들의합2 {
	static int N, M, cnt;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N]; // 수열 저장 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			accSum(i, arr[i]); // 누적합 메서드 호출
		}
		
		System.out.print(cnt);
	}
	
	static void accSum(int idx, int sum) {
		if(sum > M) return; // 합이 M 초과하면 리턴
		else if(sum == M) { // 합이 M이 되면 카운트하고 리턴
			cnt ++;
			return;
		}
		
		if(idx == N-1) return; // 인덱스 N 이상 못 감
		
		accSum(idx+1, sum + arr[idx+1]); // 다음 인덱스, 다음 값 누적합
	}
}