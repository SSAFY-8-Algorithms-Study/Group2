import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * BOJ 17608 Bronze 2
 * 막대기
 * 1. 배열에 담아
 * 2. 뒤에서부터 탐색
 * 3. 현재 최대높이보다 높은 막대기를 탐색하면 cnt++
 */
public class BOJ17608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 1. 배열에 담아
		}
		
		int maxHeight = 0;
		int cnt = 0;
		for (int i = arr.length-1; i >= 0; i--) { // 2. 뒤에서부터 탐색
			int num = arr[i];
			if(maxHeight < num) { // 3. 현재 최대높이보다 높은 막대기를 탐색하면 cnt++
				maxHeight = num;
				cnt++;
			}
		}
		System.out.print(cnt);
	}
}