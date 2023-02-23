package week24.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        int max = 0, idx = 0;
        char maxAlpha = 0;
        boolean flag = false;

        int[] alpha = new int[26];
        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 65;
            alpha[idx]++;

            if (alpha[idx] > max) {
                max = alpha[idx];
                maxAlpha = word.charAt(i);
                flag = false;
            }
            else if (alpha[idx] == max) {
                flag = true;
            }
        }

        System.out.println(flag ? "?" : maxAlpha);
    }
}
