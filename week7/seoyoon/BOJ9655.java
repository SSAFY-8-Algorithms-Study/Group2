package week7.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 백준 9655 : 돌게임 */
public class BOJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N % 2 == 1 ? "SK" : "CY");
    }
}
