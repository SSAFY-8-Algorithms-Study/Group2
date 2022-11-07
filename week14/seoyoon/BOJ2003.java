package week14.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0, sum = 0, Lpoint = 0, Rpoint = 0;

        while (true) {
            if (sum >= M) {     // sum이 M 이상이면
                sum -= arr[Lpoint++];   // 맨 첫번째 값 빼주먼서 왼쪽 포인터 이동
            }
            else {              // 아직 sum이 M보다 작다면
                if (Rpoint == N) break;
                sum += arr[Rpoint]; // 오른쪽 포인터 이동시키며 sum에 값 추가
                Rpoint++;
            }
            if (sum == M) cnt++;
        }
        System.out.println(cnt);
    }
}
