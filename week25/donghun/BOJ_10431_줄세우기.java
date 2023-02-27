package group.week_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int count;
        int[] arr;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            count = 0;
            arr = new int[20];

            int trash = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]) {
                        count++;
                    }
                }
            }

            sb.append(t).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}
