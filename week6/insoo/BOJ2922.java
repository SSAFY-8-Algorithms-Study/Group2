import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * BOJ 2922 Gold 5
 * 즐거운 단어
 */
public class BOJ_2922_즐거운단어 {
	static int cntEmpty;
	static int[] letters, selected;
	static long numCase;
	static boolean haveL;
	
	static void check() {
		int[] word = letters.clone();
		boolean isFunnyWord = true;
		boolean ishaveL = haveL;
		int idx = 0;
		
		for (int i = 0; i < word.length; i++) { // 밑줄 자리에 값 넣기
			if(word[i] == 2) {
				int sel = selected[idx++];
				if(sel == 2) {
					word[i] = 1; // L이면 자음이므로 1로 넣기
					ishaveL = true;
				} else if(sel == 1) word[i] = 1;
				else word[i] = 0;
			}
		}
		
		for(int i=2; i<word.length; i++) { // 모음이 아닌 경우 판별
			// 3연속 자음인 경우
			if(word[i-2] != 0 && word[i-1] != 0 && word[i] != 0) isFunnyWord = false;
			// 3연속 모음인 경우
			if(word[i-2] == 0 && word[i-2] == word[i-1] && word[i-1] == word[i]) isFunnyWord = false;
		}
		
		if(isFunnyWord && ishaveL) {
			long sum = 1; // 알파벳 경우의 합
			for (int i = 0; i < selected.length; i++) {
				if(selected[i] == 2) sum *= 1;
				else {
					int num = selected[i] == 1 ? 20 : 5; // (L제외)자음 20, 모음 5
					sum *= num;
				}
			}
			numCase += sum;
		}
	}
	
	static void perm(int cnt) {
		if(cnt == cntEmpty) {
			check();
			return;
		}
		for (int i = 0; i < 3; i++) { // 0 모음, 1 자음, 2 L
			selected[cnt] = i;
			perm(cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		char[] vowels = {'A', 'E', 'I', 'O', 'U'};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		letters = new int[chars.length];
		
		for (int i = 0; i < chars.length; i++) {
			if(Arrays.binarySearch(vowels, chars[i]) < 0) { // 자음
				letters[i] = 1; // 자음이면 1로 저장
				if(chars[i] == 'L') haveL = true; // L 검사
				else if(chars[i] == '_') {
					letters[i] = 2; // 밑줄이면 2로 저장
					cntEmpty++;
				}
			} // 모음 0
		}
		selected = new int[cntEmpty];
		perm(0);
		System.out.print(numCase);
	}
}