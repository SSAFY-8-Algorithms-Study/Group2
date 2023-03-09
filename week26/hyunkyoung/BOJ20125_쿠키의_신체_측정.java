import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20125_쿠키의_신체_측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int headX = -1, headY = -1;
        int leftA = 0, rightA = 0;
        int leftL = 0, rightL = 0;
        int waist = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);

                if (headX == -1 && headY == -1 && arr[i][j] == '*') {
                    headX = i; headY = j;
                    sb.append(headX + 2).append(' ').append(headY + 1).append('\n');
                }

                if (headX != -1 && i == headX + 1 && arr[i][j] == '*') {
                    if(j < headY) leftA++;
                    if(headY < j) rightA++;
                }

                if (headX != -1 && i >= headX + 2) {
                    if (j == headY && arr[i][j] == '*') waist++;
                    if (j < headY && arr[i][j] == '*') leftL++;
                    if (j > headY && arr[i][j] == '*') rightL++;
                }
            }
        }

        sb.append(leftA + " " + rightA + " " + waist + " " + leftL + " " + rightL);
        System.out.println(sb);
    }
}
