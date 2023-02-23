package week24.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 삼각형과 세 변 */
public class BOJ5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] triangle = new int[3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                triangle[i] = Integer.parseInt(st.nextToken());
            }
            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) return;
            Arrays.sort(triangle);

            if (triangle[2] >= triangle[0] + triangle[1]) System.out.println("Invalid");
            else if (triangle[0] == triangle[1] && triangle[1] == triangle[2] && triangle[2] == triangle[0]) System.out.println("Equilateral");
            else if (triangle[0] != triangle[1] && triangle[1] != triangle[2] && triangle[2] != triangle[0]) System.out.println("Scalene");
            else System.out.println("Isosceles");
        }
    }
}