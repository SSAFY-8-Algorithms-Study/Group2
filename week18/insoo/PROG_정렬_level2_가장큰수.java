package trying;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 다른 자리의 숫자 정렬 방법
 * 1. 문자로 변형시킨 후 뒤에 덧붙여서 정렬
 */
public class PROG_정렬_level2_가장큰수 {
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		
		System.out.print(Solution(numbers));
	}
	
	static String Solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int num : numbers) // 정렬을 위해서 숫자 세번 덧붙이기 (3, 34 -> 333 < 343434)
			list.add(String.valueOf(num)+String.valueOf(num)+String.valueOf(num));

		Collections.sort(list, Collections.reverseOrder()); // 문자 형태로 정렬, 앞부터 비교
		for(String e : list)
			sb.append(e.substring(0, e.length()/3)); // 덧붙인 거 빼주기
		
        return list.get(0).charAt(0) == '0' ? "0" : sb.toString(); // "000" 예외 처리
	}
}