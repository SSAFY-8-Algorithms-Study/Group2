import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157_단어_공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] alpha = new int[26];
        for (char chr : str.toCharArray()) {
            alpha[chr - 65] += 1;
        }

        int maxCnt = -1;
        char maxAlpha = '?';
        for (int i = 0; i < 26; i++) {
            if(alpha[i] > maxCnt) {
                maxCnt = alpha[i];
                maxAlpha = (char) (i + 65);
            } else if (alpha[i] == maxCnt) {
                maxAlpha = '?';
            }
        }

        System.out.println(maxAlpha);
    }
}
