package trying;

import java.util.ArrayList;
import java.util.Collections;

public class PROG_정렬_level1_K번째수 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.print(Solution(array, commands));
	}
	
	static int[] Solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0] - 1; // 시작 위치 인덱스
			int end = commands[i][1] - 1; // 끝 위치 인덱스
			int idx = commands[i][2] - 1; // 정렬 후 위치 인덱스
			
			ArrayList<Integer> list = new ArrayList<>();
			while(start <= end) {
				list.add(array[start++]); // 리스트에 담기
			}
			
			Collections.sort(list); // 정렬
			
			answer[i] = list.get(idx); // 위치 인덱스에 맞는 값 기록
		}
		
        return answer;
	}
}