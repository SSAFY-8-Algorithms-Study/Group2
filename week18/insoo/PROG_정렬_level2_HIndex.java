package trying;

import java.util.Arrays;
/*
 * 정렬 후 이분 탐색 함수 사용해 위치 확인
 */
public class PROG_정렬_level2_HIndex {
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5}; // 3
		
		System.out.print(Solution(citations));
	}
	
	static int Solution(int[] citations) {
		Arrays.sort(citations); // 오름차순 정렬
		int len = citations.length;
		
		for (int i = citations[len-1]; i >= 0; i--) { // 가장 큰 수부터 0까지 탐색
			int idx = Math.abs(Arrays.binarySearch(citations, i)+1); // 이분탐색으로 들어갈 위치 찾기
			
			// i번 이상 인용된 논문이 i편 이상일 때
			// i와 같은 값이 배열에 있는지 확인, 있으면 +1
			if(i <= len-idx + (citations[idx-1 < 0 ? 0 : idx-1] == i ? 1 : 0)) {
				return i;
			}
		}
		
        return 0;
	}
}