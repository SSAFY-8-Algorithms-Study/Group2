import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 14225 Silver 1
 * 부분수열의 합
 */
public class BOJ_14225_부분수열의합 {
	static int N, max;
	static int[] list;
	static boolean[] resultList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			max += list[i];
		}
		
		resultList = new boolean[max+2];
		
		powerSet(0, 0);
		
		for (int i = 1; i < resultList.length; i++) {
			if(!resultList[i]) {
				System.out.print(i);
				return;
			}
		}
	}
	
	static void powerSet(int idx, int sum) {
		if(idx == N) {
			resultList[sum] = true;
			return;
		}
		
		powerSet(idx+1, sum + list[idx]);
		powerSet(idx+1, sum);
	}
}