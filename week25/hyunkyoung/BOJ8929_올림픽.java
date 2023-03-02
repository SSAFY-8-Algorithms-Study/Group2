import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ8929_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] teams = new int[N][4];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            teams[n][0] = Integer.parseInt(st.nextToken());

            for (int m = 1; m <= 3; m++) {
                teams[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(teams, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                if(o1[2] == o2[2]) {
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
            return o2[1] - o1[1];
        });

        int rank = 0, tie = 1;
        boolean isSame;

        for (int n = 0; n < N; n++) {
            if (n > 0 && teams[n][1] == teams[n - 1][1] && teams[n][2] == teams[n - 1][2] && teams[n][3] == teams[n - 1][3]) {
                isSame = true;
                tie++;
            } else {
                isSame = false;
            }

            if (!isSame) {
                rank += tie;
                tie = 1;
            }

            if (K == teams[n][0]) {
                System.out.println(rank);
                break;
            }
        }
    }
}
