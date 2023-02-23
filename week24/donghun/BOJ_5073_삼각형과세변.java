package group.week_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5073_삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // 종료
            if (x+y+z==0) break;

            // 무효
            if ((x+y<=z) || (x+z<=y) || (y+z<=x)) {
                sb.append("Invalid\n");
                continue;
            }

            // 세변같
            if (x == y && x == z) {
                sb.append("Equilateral\n");
                continue;
            }

            // 두변같
            if (x==y && x!=z) {
                sb.append("Isosceles\n");
                continue;
            }
            if (x==z && x!=y) {
                sb.append("Isosceles\n");
                continue;
            }
            if (y==z && y!=x) {
                sb.append("Isosceles\n");
                continue;
            }

            // 다름
            sb.append("Scalene\n");
        }

        System.out.println(sb);
    }
}
