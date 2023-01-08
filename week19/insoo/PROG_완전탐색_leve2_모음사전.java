package trying;

public class PROG_완전탐색_leve2_모음사전 {
	public static void main(String[] args) {
		String word = "EIO";
		
		System.out.print(Solution(word));
	}
	
	static int Solution(String word) {
		char[] vowels = {'A', 'E', 'I', 'O', 'U'}; // 모음 모음
		// A가 1이고, I가 1563이니까
		// E는 782
		// 첫번째 자리 = (781 * 모음 위치(ex: A=0, E=1)) + 1
		// 두번째 자리 = ((781-1)/5 * 모음 위치(ex: A=0, E=1)) + 1
		// 세번째 자리 = ((((781-1)/5)-1)/5 ...
		int[] numbs = {781, 156, 31, 6, 1};
        int answer = 0;
		
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < vowels.length; j++) {
				if(vowels[j] == word.charAt(i)) {
					answer += (numbs[i] * j) + 1;
				}
			}
		}
		
		return answer;
	}
}