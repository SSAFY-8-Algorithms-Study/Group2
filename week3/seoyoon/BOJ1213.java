package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        // 알파벳 A부터 시작해 '빈도수/2' 만큼 String에 추가
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }

        int odd = 0;
        for (int i = 0; i < 26; i++) {
            // 해당 문자의 빈도수가 홀수인 경우 String에 추가
            if (alpha[i] % 2 == 1) {
                for (int j = 0; j < alpha[i] % 2; j++) {
                    sb.append((char)(i + 'A'));
                }
                odd++;
            }
            // 홀수인 경우가 1 이상이면 팰린드롬 불가능
            if (odd > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        // 알파벳 Z부터 시작해 '빈도수/2' 만큼 String에 추가
        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)((i) + 'A'));
            }
        }

        System.out.println(sb);
        return;
    }
}
