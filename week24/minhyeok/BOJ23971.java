package week24.minhyeok;

import java.io.*;
import java.util.*;

/**
 * Tier: BRONZE 3
 * Title: ZOAC 4
 * Category: 수학, 사칙연산
 *
 * 한 줄의 길이를 한 명이 차지하는 개수로 나누어주었다.
 * 단, 나머지가 0보다 크다면 한 명이 더 들어올 수 있다.
 */

public class BOJ23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int row = H / (N+1);
        if (H % (N+1) > 0) row += 1;

        int col = W / (M+1);
        if (W % (M+1) > 0) col += 1;

        System.out.println(row * col);
    }
}