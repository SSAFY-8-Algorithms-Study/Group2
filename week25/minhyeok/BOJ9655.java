package week25.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9655 {

    /**
     * Tier: Silver 5
     * Title: 돌 게임
     * Category: 수학, 다이나믹 프로그래밍, 게임 이론
     *
     * 홀수가 주어지면 상근이가 이긴다..
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N%2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}