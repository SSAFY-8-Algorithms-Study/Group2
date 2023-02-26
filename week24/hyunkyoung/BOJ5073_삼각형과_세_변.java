package week24.hyunkyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5073_삼각형과_세_변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;

            int sum = a + b + c;
            int max = Math.max(Math.max(a, b), c);
            if(max >= sum - max) {
                System.out.println("Invalid");
                continue;
            }

            if(a == b && b == c) System.out.println("Equilateral");
            if((a == b && b != c) || (a == c && c != b) || (b == c && c != a)) System.out.println("Isosceles");
            if(a != b && b != c && c != a) System.out.println("Scalene");
        }
    }
}
