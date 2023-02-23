package group.week_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157_단어공부 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();

        int[] arr = new int[26];
        int max = 0;
        char answer = 0;

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 65]++;
            if (arr[str.charAt(i) - 65] > max) {
                answer = str.charAt(i);
                max = arr[str.charAt(i) - 65];
            } else if (max == arr[str.charAt(i) - 65]) {
                answer = '?';
            }
        }

        System.out.println(answer);


    }

}
