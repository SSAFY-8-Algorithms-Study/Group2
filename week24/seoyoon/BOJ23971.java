package week24.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* ZOAC 4 */
public class BOJ23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int height = H / (1 + N);
        int width = W / (1 + M);

        if (H % (1 + N) != 0) {
            height++;
        }
        if (W % (1 + M) != 0) {
            width++;
        }

        System.out.println(height * width);
    }
}
