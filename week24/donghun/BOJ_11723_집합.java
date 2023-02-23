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
        boolean[] arr = new boolean[21]; // on/off 기록 배열

        int T = Integer.parseInt(br.readLine()); // 리인 수

        while (T-- > 0) { // T만큼 반복
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken(); // add부터 empty까지

            int idx = -1; // idx 초기화

            // x가 필요로 하는 경우의 if 처리
            if (type.equals("add") || type.equals("remove") || type.equals("check") || type.equals("toggle")) {
                idx = Integer.parseInt(st.nextToken());
            }

            switch (type) {
                case "add":
                    arr[idx] = true; // 불 켜고
                    break;
                case "remove":
                    arr[idx] = false; // 불 끄고
                    break;
                case "check":
                    if (arr[idx]) sb.append(1 + "\n"); // 불 켜져있으면 1 추가
                    else sb.append(0 + "\n"); // 꺼져있으면 0 추가
                    break;
                case "toggle":
                    arr[idx] = !arr[idx]; // 토글
                    break;
                case "all":
                    Arrays.fill(arr, true); // true로 채우고
                    break;
                case "empty":
                    Arrays.fill(arr, false); // false로 채우고
                    break;
            }
        }
        System.out.println(sb);
    }
}
