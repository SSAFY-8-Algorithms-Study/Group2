package week1.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100 {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr = new String[8][8];
        int count = 0;

        // start 입력
        for (int i = 0; i < arr.length; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = str[j];
            }
        }
        // end 입력

        // start 로직
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if ((i + j) % 2 == 0 && arr[i][j].equals("F")) {
                    count++;
                }
            }
        }
        // end 로직

        // 출력
        System.out.println(count);
    }
}