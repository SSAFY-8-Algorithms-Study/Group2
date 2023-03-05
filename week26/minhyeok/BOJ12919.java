package week26.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12919 {

    /**
     * Tier:
     * GOLD 5
     * Title: A와 B 2
     * Category: 구현, 문자열, 브루트포스, 재귀
     *
     * T에서 문자를 하나씩 제거해보며 S가 될 수 있는지 확인한다.
     * 첫번째 문자가 B이면 첫번째 문자를 제외하고 T를 뒤집는다.
     * 마지막 문자가 A이면 마지막 문자를 제거한다.
     *
     */

    static boolean isAnswer = false;

    private static String reverse(String str) {
        String result = "";
        int size = str.length();
        for (int i = size-1; i >= 0; i--) {
            result += (char) str.charAt(i);
        }
        return result;
    }

    private static void dfs(String myString, String targetString) {
        if (myString.length() == targetString.length()) {
            if (targetString.equals(myString)) isAnswer = true;
            return;
        }

        int length = targetString.length();

        if (targetString.charAt(0) == 'B') {
            dfs(myString, reverse(targetString.substring(1,length)));
        }

        if (targetString.charAt(length-1) == 'A') {
            dfs(myString, targetString.substring(0,length-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        dfs(S,T);
        if (isAnswer) System.out.println(1);
        else System.out.println(0);
    }
}
