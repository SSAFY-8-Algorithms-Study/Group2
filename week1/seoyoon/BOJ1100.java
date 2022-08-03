package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chessMap = new char[8][8];
        int ans = 0;

        for (int i = 0; i < 8; i++) {
            chessMap[i] = br.readLine().toCharArray();

            // 홀수번째 줄일 때 흰->검
            if ((i+1) % 2 == 1) {
                for (int j = 0; j < 8; j+=2) {
                    if (chessMap[i][j] == 'F') {
                        ans++;
                    }
                }
            }
            // 짝수번째 줄일 때 검->흰
            else {
                for (int j = 1; j < 8; j += 2) {
                    if (chessMap[i][j] == 'F') {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
