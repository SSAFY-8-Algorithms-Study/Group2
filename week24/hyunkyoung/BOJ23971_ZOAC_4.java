package week24.hyunkyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ23971_ZOAC_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 1;

        if(H % (N + 1) != 0) result *= (H / (N + 1) + 1);
        else result *= (H / (N + 1));

        if(W % (M + 1) != 0) result *= (W / (M + 1) + 1);
        else result *= (W / (M + 1));

        System.out.println(result);
    }
}
