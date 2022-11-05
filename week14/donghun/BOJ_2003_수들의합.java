package group.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합 {
    static int N, M, count; // N: 원소 수, M: 목표 값, count: 부분 수열의 합이 M이 되는 경우의 수
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 부분 수열의 길이를 1부터 N까지 탐색
        for (int len = 1; len <= N; len++) {

            // 초기화
            int sum = 0;

            // 초기 슬라이드 값 서정
            for (int i = 0; i < len; i++) {
                sum += arr[i];
            }

            // 초기 값 단계에서 M이 달성됐으면 count++ 및 continue
            if (sum == M) {
                count++;
            }

            // 각 길이 별 슬라이딩 윈도우 -> sum==M 달성 체크
            for (int i = 0; i < N-len; i++) {
                sum = sum - arr[i] + arr[i+len];
                if (sum == M) {
                    count++;
                }
            }
        }

        // 출력
        System.out.println(count);
    }
}
