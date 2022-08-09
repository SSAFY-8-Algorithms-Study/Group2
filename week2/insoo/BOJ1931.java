package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * BOJ 1931 silver 1
 * 회의실 배정
 * 1. 회의 끝나는 시간을 기준으로 오름차순 정렬
 * 2. 다음 회의 시작 시간이 이전 회의 끝나는 시간보다 같거나 크다면 조건에 부합하므로 selectedEnd에 할당
 * 3. 회의 배정으로 cnt++
 */
public class BOJ1931 {
	static int selectedEnd, cnt;
	
	static void schedule(int nextStart, int nextEnd) {
		// 2. 다음 회의 시작 시간이 이전 회의 끝나는 시간보다 같거나 크다면 조건에 부합하므로 selectedEnd에 할당
		if(selectedEnd <= nextStart) {
			selectedEnd = nextEnd;
			// 3. 회의 배정으로 cnt++
			cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		selectedEnd = 0;
		cnt = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 1. 회의 끝나는 시간을 기준으로 오름차순 정렬
		Arrays.sort(arr, (a,b) -> {
			if(a[1]==b[1]) return a[0]-b[0];
			return a[1]-b[1];
		});
		for (int i = 0; i < arr.length; i++) {
			schedule(arr[i][0], arr[i][1]);
		}
		
		System.out.print(cnt);
	}
}