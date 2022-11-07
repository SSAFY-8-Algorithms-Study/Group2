package group.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11060_점프점프 {
    static int N, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 불가능 Case: 출력 -1
        ans = -1;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 길이가 1이면 0회 시 가능
        if (N==1) {
            System.out.println(0);
            System.exit(0);
        }
        
        // 길이가 1인 경우는 걸러졌고, N>=2에서 0번 인덱스 값이 0이면 점프가 불가능
        if (arr[0] == 0) {
            System.out.println(-1);
            System.exit(0);
        }

        // 시간 초과
        // dfs(0, 0);

        bfs();

        // 출력 분기
        System.out.println(ans==-1?-1:ans+1);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        q.add(0);
        visited[0] = true;

        outer:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int idx = q.poll();

                if (idx == N - 1) return;

                int val = arr[idx];
                if (val == 0) continue;

                // arr[idx]에 주어진 값만큼 모두 돌려주고 queue add
                for (int i = 1; i <= val; i++) {
                    int nextIdx = idx + i;
                    if (nextIdx < 0 || nextIdx >= N) continue;
                    if (!visited[nextIdx]) {
                        q.add(nextIdx);
                        visited[nextIdx] = true;
                    }
                }
            }
            // count 증가
            ans++;
        }
         // 불가능 Case: 출력 -1
        ans = -1;
    }

//    private static void dfs(int idx, int turn) {
//
//        if (idx >= N - 1) {
//            ans = Math.min(ans, turn);
//            return;
//        }
//
//        int val = arr[idx];
//
//        if (val == 0) return;
//
//        for (int i = 1; i <= val; i++) {
//            dfs(idx + i, turn + 1);
//        }
//    }
}
