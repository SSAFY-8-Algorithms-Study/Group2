package group.week_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 모든 경우의 수(1+1, 1+3, 3+3)는 짝수이므로 홀짝문제
        if (N%2==0) System.out.println("CY");
        else System.out.println("SK");
    }
}
