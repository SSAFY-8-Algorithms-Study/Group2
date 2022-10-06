import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 18353 Silver 2
 * 병사 배치하기
 */
public class BOJ_18353_병사배치하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N+1];
		list[0] = 10_000_000;
		
		int[] lenList = new int[N+1]; // 자신을 끝으로 가지는 최장 길이 리스트
		
		int maxLen = 0;

		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());

			for (int j = 0; j < i; j++) {
				if(list[i] < list[j]) {
					lenList[i] = Math.max(lenList[i], lenList[j]+1);
					
					maxLen = Math.max(maxLen, lenList[i]);
				}
			}
		}
		System.out.print(N-maxLen);
	}
}