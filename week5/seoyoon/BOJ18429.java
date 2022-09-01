package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ18429 - 근손실 */
public class BOJ18429 {
    static int N, K, ans;
    static int[] exercise, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        exercise = new int[N];
        result = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            exercise[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(ans);
    }

    public static void perm(int cnt) {
        if (cnt == N) {
            int W = 500;

            for (int i = 0; i < result.length; i++) {
                W += (result[i]- K);    // 각 운동 키트의 중량 증가량만큼 (+), K 만큼 (-)
                if (W < 500) return;    // 500 미만으로 떨어지면 종료
            }
            ans++;
            return;
        }

        for (int i = 0; i < exercise.length; i++) {
            if (visited[i]) continue;

            result[cnt] = exercise[i];
            visited[i] = true;
            perm(cnt + 1);  // 가능한 모든 운동 키트 적용 순서를 순열로 생성
            visited[i] = false;
        }
    }
}
