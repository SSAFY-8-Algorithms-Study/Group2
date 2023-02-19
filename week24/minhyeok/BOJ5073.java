package week24.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5073 {

    /**
     * Tier: BRONZE 3
     * Title: 삼각형과 세 변
     * Category: 수학, 구현, 기하학
     *
     * 삼각형이 될 수 있는지 여부, 삼각형의 종류에 따라 알맞은 답을 출력한다.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int l3 = Integer.parseInt(st.nextToken());

            if (l1 == 0 && l2 == 0 && l3 == 0) break;

            int[] lines = {l1, l2, l3};
            Arrays.sort(lines);

            if (lines[0] + lines[1] <= lines[2]) {
                System.out.println("Invalid");
                continue;
            } else if ((lines[0] == lines[1]) && (lines[1] == lines[2])) {
                System.out.println("Equilateral");
                continue;
            } else if ((lines[0] == lines[1]) || (lines[1] == lines[2]) || lines[0] == lines[2]) {
                System.out.println("Isosceles");
                continue;
            } else {
                System.out.println("Scalene");
                continue;
            }
        }
    }

}
