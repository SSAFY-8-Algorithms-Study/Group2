package group.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2607_1번_비슷한단어_S3 {

    static int[] first;
    static int[] copy;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        first = new int[26];
        copy = new int[26];

        // compare 문자열 입력 라인 수
        int T = Integer.parseInt(br.readLine());

        // base 문자열 입력
        String base = br.readLine();
        // base 문자열 길이
        int size = base.length();

        // base 초기값 입력
        for (int i = 0; i < size; i++) {
            first[base.charAt(i) - 'A']++;
        }

        outer:
        for (int t = 1; t < T; t++) {
            // 비교군 입력
            String input = br.readLine();
            // 길이 체크
            int cSize = input.length();

            // 길이 가망X -> 다음놈
            if (Math.abs(size - cSize) > 1) {
//                System.out.println("???");
                continue;
            }

            // 둘다 size가 1이면 둘다 지우면 ok니까 패스
            if (size == 1 && cSize == 1) {
                cnt++;
                continue;
            }

            ///////////////////////////////////////////////

            // 가망O? 일 시작
            System.arraycopy(first, 0, copy, 0, 26); // first 복제

            // 비교군 배열 만들어줌
            int[] compare = new int[26];
            for (int i = 0; i < cSize; i++) {
                compare[input.charAt(i) - 'A']++;
            }

            // 체크 한 번 더. first는 1인데 compare는 0인게 2번 이상이면 다음 String 입력으로
            int check = 0;
            for (int i = 0; i < 26; i++) {
                if (first[i] == 1 && compare[i] == 0) {
                    check++;
                    if (check > 1)
                        continue outer;
                }
            }

            if (isOk(compare)) cnt++;

        }

        System.out.println(cnt);

    }

    static boolean isOk(int[] compare) {
        for (int i = 0; i < 26; i++) {
            if (Math.abs(copy[i] - compare[i]) > 1) return false;
        }
        return true;
    }
}
