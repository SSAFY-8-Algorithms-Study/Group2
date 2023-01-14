package trying;

import java.util.Arrays;

public class PROG_탐욕법_leve1_체육복 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1,3,5}; // expect 5
		
		System.out.print(Solution(n, lost, reserve));
	}
	
	static int Solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost); // 정렬해야 한다네
		Arrays.sort(reserve);
        
		boolean[] visit = new boolean[n + 2];
		int sum = 0;
		
		for(int e : lost) {
			if(Arrays.binarySearch(reserve, e) >= 0) { // 잃어버린 사람 중 여벌을 챙겨온 사람 확인
				visit[e] = true; // 기록
				sum++;
			}
		}
		
		cycle: // 라벨링
		for(int e : lost)
			for (int i = -1; i <= 1; i += 2) // -1, 1 앞번호 뒷번호 빌려주기
				if(!visit[e] && !visit[e + i] && Arrays.binarySearch(reserve, e + i) >= 0) { // 방문하지 않았고, 앞뒤 중 빌릴 수 있는 학생 체크
					visit[e + i] = true; // 기록
					sum++;
					continue cycle; // 앞에서 빌렸으면 뒤 학생 생략
				}
		
		return (n - lost.length) + sum; // (전체 학생 수 - 잃어버린 사람) + 대체한 사람
	}
}