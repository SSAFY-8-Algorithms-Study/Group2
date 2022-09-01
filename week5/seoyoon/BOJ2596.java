package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2596 {
    static String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H"};
    static String[] password =	{"000000",		// A
            "001111",		// B
            "010011",		// C
            "011100",		// D
            "100110",		// E
            "101001",		// F
            "110101",		// G
            "111010"};		// H

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        String[] letter = new String[N];
        for (int i = 0; i < N; i++) {
            letter[i] = input.substring(i * 6, i * 6 + 6);        // N = 3) idx : (0 ~ 5), (6 ~ 11), (12 ~ 17) - 6개씩 끊어서 배열 저장
        }

        for (int i = 0; i < letter.length; i++) {
            boolean isFind = false;

            for (int j = 0; j < password.length; j++) {
                int diff = 0;

                for (int idx = 0; idx < 6; idx++) {
                    if (letter[i].charAt(idx) != password[j].charAt(idx)) diff++;   // 일치하지 않는 문자 발생 시 diff 증가
                }

                if (diff < 2) {     // 2개 미만이면 OK~
                    letter[i] = alpha[j];
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {      // 일치하는 문자를 못찾았다면
                System.out.println(i + 1);      // index 출력
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(letter[i]);
        }
    }
}
