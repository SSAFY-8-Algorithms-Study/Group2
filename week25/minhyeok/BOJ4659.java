package week25.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659 {

    /**
     * Tier: Silver 5
     * Title: 비밀번호 발음하기
     * Category: 구현, 문자열
     *
     * 세 가지 높은 품질의 비밀번호 조건에 맞는 로직을 구현한다.
     *
     */

    static void print(String pw, boolean isValid) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(pw);
        sb.append("> is ");
        if (!isValid) sb.append("not ");
        sb.append("acceptable.");
        System.out.println(sb.toString());
    }

    static char[] vowels = {'a','e','i','o','u'};

    static boolean isVowel(char c) {
        for (char vowel : vowels) {
            if (vowel == c) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String pw = br.readLine();
            if ("end".equals(pw)) break;
            boolean hasVowel = false;
            int consonantCnt = 0;
            int vowelCnt = 0;
            char lastWord = ' ';
            boolean isValid = true;

            int size = pw.length();
            for (int i = 0; i < size; i++) {
                char c = pw.charAt(i);
                // 모음일 경우, 자음일 경우
                if (isVowel(c)) {
                    hasVowel = true;
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    vowelCnt = 0;
                    consonantCnt++;
                }
                // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
                if (vowelCnt == 3 || consonantCnt == 3) {
                    isValid = false;
                    break;
                }
                // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
                if (lastWord == c && lastWord != 'e' && lastWord != 'o') {
                    isValid = false;
                    break;
                }
                lastWord = c;
            }

            // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
            if (!hasVowel || !isValid) print(pw, false);
            else print(pw, true);
        }

    }
}
