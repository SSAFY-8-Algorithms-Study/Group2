package week13.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ2607:비슷한 단어 */
public class BOJ2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String word = br.readLine();					// 기준이 되는 첫 번째 단어 입력
        int[] wordArr = countAlphabet(word);

        int similarCnt = 0;								// 비슷한 단어 count하는 변수
        for (int i = 0; i < n - 1; i++) {
            String newWord = br.readLine();				// 각 단어를 입력받아
            int[] newWordArr = countAlphabet(newWord);	// 알파벳 빈도수 배열을 만들어주고

            if (isSimilarWord(wordArr, newWordArr)) {
                similarCnt++; 							// 비슷한 단어라면 similarCnt + 1
            }
        }

        System.out.println(similarCnt);
    }

    public static int[] countAlphabet(String word) {	// 단어에 각 알파벳이 몇 개 들어가는지 count 하는 메소드
        int[] alpha = new int[26];
        for(int i = 0; i < word.length(); i++) {
            alpha[word.charAt(i) - 'A']++;
        }
        return alpha;
    }

    public static boolean isSimilarWord(int[] wordArr, int[] newWordArr) {	// 두 단어가 비슷한 단어인지 판별하는 메소드
        int cnt = 0;														// wordArr와 newWordArr 사이의 오차가 얼마나 있는지 count
        int waFlag = 0, nwaFlag = 0;

        for (int i = 0; i < 26; i++) {
            if (wordArr[i] - newWordArr[i] == 1) waFlag++;					// '하나의 문자를 다른 문자로 바꾸어 나머지 한 단어와 같은 구성을 갖게 되는 경우' 조건 체크
            if (newWordArr[i] - wordArr[i] == 1) nwaFlag++;

            cnt += Math.abs(wordArr[i] - newWordArr[i]);					// '두 단어가 같은 구성을 갖는 경우, 또는 한 단어에서 한 문자를 더하거나, 뺐을 때 같은 구성을 갖게 되는 경우' 조건 체크
        }

        if (cnt <= 1 || (cnt <= 2 && waFlag == 1  && nwaFlag == 1)) return true;		// 오차가 1 이하 or 하나의 문자를 다른 문자로 바꾸었을 때 구성이 같아지면 -> 비슷한 단어이므로 true 리턴
        return false;														// 아니라면 false 리턴
    }
}