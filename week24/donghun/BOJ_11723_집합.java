package group.week_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[21];

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            int idx = -1;
            if (type.equals("add") || type.equals("remove") || type.equals("check") || type.equals("toggle")) {
                idx = Integer.parseInt(st.nextToken());
            }

            switch (type) {
                case "add":
                    arr[idx] = true;
                    break;
                case "remove":
                    arr[idx] = false;
                    break;
                case "check":
                    if (arr[idx]) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "toggle":
                    arr[idx] = !arr[idx];
                    break;
                case "all":
                    Arrays.fill(arr, true);
                    break;
                case "empty":
                    Arrays.fill(arr, false);
                    break;
            }
        }
        System.out.println(sb);
    }
}
