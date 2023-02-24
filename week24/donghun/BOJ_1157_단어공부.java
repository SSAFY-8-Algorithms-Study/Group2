package group.week_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157_단어공부 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();

        int[] arr = new int[26]; // 알파벳 배열
        int max = 0; // 가장 많은 알파벳
        char answer = 0; // max 알파벳

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 65]++; // 들어온 알파벳 갯수 증가
            if (arr[str.charAt(i) - 65] > max) { // 기존 max보다 커졌으면
                answer = str.charAt(i); // 갱신
                max = arr[str.charAt(i) - 65]; // max 값도 갱신
            } else if (max == arr[str.charAt(i) - 65]) { // 같은게 있으면
                answer = '?'; // ?로 갱신
            }
        }

        System.out.println(answer); // 최종 출력
    }
}
