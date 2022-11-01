package group.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14267_4번_회사문화1_G4 {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] boss, praise;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사장 포함 직원 수
        M = Integer.parseInt(st.nextToken()); // 칭찬 수치

        // index - value 매칭 -> e.g) [2]의 값이 1이면 2번 직원의 상사는 1번 / [2]의 값이 2이면 2번 직원이 받은 칭찬 수치는 2
        boss = new int[N + 1]; // 직속상사를 갱신할 배열
        praise = new int[N + 1]; // 직원에게 할당될 칭찬 수치를 갱신할 배열

        // 연결리스트배열 초기화
        list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 상사-부하 그래프 연결
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss == -1) continue;

            list[boss].add(i);
        }

        // 칭찬 받은 직원 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int boss = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            praise[boss] += point;
        }

        dfs(1, 0);

        // 출력
        for (int i=1; i<N+1; i++) {
          sb.append(praise[i]).append(" ");
        }

        System.out.println(sb);
    }

    // dfs타고 안으로 갈수록 더해줄 것임
    private static void dfs(int boss, int cnt) {
        praise[boss] += cnt;
        for (int i = 0; i < list[boss].size(); i++) {
            dfs(list[boss].get(i), praise[boss]);
        }
    }
}
