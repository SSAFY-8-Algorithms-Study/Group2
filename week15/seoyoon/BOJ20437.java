package week15.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ20437 : 문자열 게임2 */
public class BOJ20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[] alpha = new int[26];
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            int firstAns = Integer.MAX_VALUE, secAns = -1;				// firstAns :: 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이, secAns :: 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이

            for (int LPoint = 0; LPoint < str.length(); LPoint++) {
                int curAlpha = str.charAt(LPoint) - 'a';

                if (alpha[curAlpha] >= K) {								// 해당 문자의 빈도수가 K개 이상이라면 답이 될 수 있는 후보~
                    int freqCount = 0;
                    for (int RPoint = LPoint; RPoint < str.length(); RPoint++) {

                        if (str.charAt(LPoint) == str.charAt(RPoint)) freqCount++;	// 문자 빈도수 count

                        if (freqCount == K) { 										// 어떤 문자를 정확히 K개 포함한다면
                            firstAns = Math.min(firstAns, RPoint - LPoint + 1);		// 최단 길이와
                            secAns = Math.max(secAns, RPoint - LPoint + 1);			// 최장 길이 구하기
                            break;
                        }
                    }
                }
            }
            System.out.println(firstAns == Integer.MAX_VALUE || secAns == -1 ? -1 : firstAns + " " + secAns);
        }
    }
}
