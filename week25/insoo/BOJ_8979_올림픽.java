package algo;
import java.io.*;
import java.util.*;
class BOJ_8979_올림픽 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] medalList = new int[N+1][4];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int country = Integer.parseInt(st.nextToken());
			
			for (int medal = 0; medal < 3; medal++) {
				medalList[country][medal] = Integer.parseInt(st.nextToken());
			}
			
			medalList[country][3] = country;
		}

		Arrays.sort(medalList, (a,b) -> {
			if(a[0] == b[0]) { // 금메달 수 정렬
				if(a[1] == b[1]) { // 은메달 수 정렬
					if(a[2] == b[2]) // 동메달 수 정렬
						return a[3] - b[3]; // 국가 번호로 정렬
					return b[2] - a[2];
				}
				return b[1] - a[1];
			}
			return b[0] - a[0];
		});
		
		int rank = 1;
		int restRank = 0;
		
		for (int i = 0; i < medalList.length; i++) {
			if(0 < i) {
				for (int j = 0; j < 3; j++) { // 같은 등수 인지 검사
					if(medalList[i-1][j] != medalList[i][j]) {
						rank += restRank + 1; // 등수 기록
						restRank = 0; // 초기화
						break;
					}
					if(j==2) restRank++; // 같은 등수 아니면 +1
				}
			}
			
			if(medalList[i][3] == K) { // K 찾기
				System.out.print(rank);
				break;
			}
		}
	}
}