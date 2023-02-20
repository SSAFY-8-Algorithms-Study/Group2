import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int turn = 1;
        int start = 1;
        int end = 1;

        while (true) {
            if (start <= N && N <= end) {
                System.out.println(turn);
                break;
            }

            start = end + 1;
            end += turn * 6;
            turn++;
        }
    }
}
