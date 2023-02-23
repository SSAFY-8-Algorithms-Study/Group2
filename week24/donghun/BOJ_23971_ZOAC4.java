package group.week_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23971_ZOAC4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 강의실 세로
        int W = Integer.parseInt(st.nextToken()); // 강의실 가로

        int N = Integer.parseInt(st.nextToken()); // 비워야 할 세로
        int M = Integer.parseInt(st.nextToken()); // 비워야 할 가로

        /////

        int x = H/(N+1); // 기본 값을 갖고
        if (H%(N+1) != 0) { // 나머지가 있으면 하나 더 들어갈 수 있으므로
            x++; // 더함
        }

        int y = W/(M+1); // 동일
        if (W%(M+1) != 0) {
            y++;
        }

        System.out.println(x*y); // 2차원
    }
}
