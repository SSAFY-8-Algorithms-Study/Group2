import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 10025 Silver 3
 * 게으른 백곰
 */
public class BOJ_10025_게으른백곰 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 얼음 양동이 수
		int K = Integer.parseInt(st.nextToken()); // 백곰 이동 범위
		int[] arr = new int[1_000_001];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken()); // 양동이 얼음 양
			int x = Integer.parseInt(st.nextToken()); // 좌표
			arr[x] = g;
		}
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i-1]; // 누적합
			
			int outRange = (i-(K*2))-1; // 백곰 이동 범위 밖
			max = outRange < 0 ? Math.max(max, arr[i]) : Math.max(max, arr[i] - arr[outRange]);
		}
		System.out.print(max);
	}
}