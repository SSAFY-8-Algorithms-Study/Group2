package trying;
/*
 * 1. 소수 기록
 * 2. 비중복 순열
 * 3. 문자별 소수 판별 후 기록
 */
public class PROG_완전탐색_leve2_소수찾기 {
	public static void main(String[] args) {
		String numbers = "17";
//		String numbers = "011";
		
		System.out.print(Solution(numbers));
	}
	
	static int len, answer;
	static int MAX = 9_999_999; // 입력 가능 최대값
	static String input;
	static boolean[] decimal, selected;
	
	
	static int Solution(String numbers) {
		input = numbers; // 입력문자
		len = numbers.length(); // 입력문자 길이
		decimal = new boolean[MAX+1]; // 값이 인덱스인 소수 판별 배열
		selected = new boolean[len]; // 순열 선택
		
		getDecimal(); // 소수 판별 메서드 호출
		perm(""); // 순열 호출
		
		return answer;
	}
	
	static void getDecimal() { // 소수 판별 메서드
		decimal[1] = true;
		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			int j = 2;
			while(i*j<=MAX) {
				decimal[i*j] = true;
				j++;
			}
		}
	}
	
	static void perm(String str) { // 비중복 순열
		if(str.equals("0")) return;
		if(str.length() > 0) { // str 길이 1이상일 때
			int num = Integer.parseInt(str); // 숫자로 변환
			if(!decimal[num]) { // 소수인지
				decimal[num] = true; // 해당 값 기록했으니 중복 제거 처리
				answer++;
			}
		}
		if(str.length() == len) return;
		
		for (int i = 0; i < len; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			perm(str + input.charAt(i)); // 백트래킹으로 순열 만들기
			selected[i] = false;
		}
	}
}