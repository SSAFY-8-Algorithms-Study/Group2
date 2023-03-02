import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());

        for(int p = 0; p < P; p++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            int result  = 0;

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < 20; i++) {
                int curr = i;
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]) {
                        curr = j;
                        break;
                    }
                }

                if (curr != i) {
                    int tmp = arr[i];
                    for (int c = i; c > curr; c--) {
                        arr[c] = arr[c - 1];
                        result++;
                    }
                    arr[curr] = tmp;
                }
            }

            sb.append(T + " " + result).append('\n');
        }

        System.out.println(sb);
    }
}
