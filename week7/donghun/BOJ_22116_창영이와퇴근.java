package week7.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22116 {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int l=0;
    static int r=1000000000;
    static int mid, result;
    static Queue<Hill> q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        // 입력 종료

        // 높이차
        result = r - l;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (bfs()) { // mid 기어비로 도달 가능하면
                result = mid; // 더 조여봐
                r = mid - 1;
            } else // 경로 없으면 돈으로 때리고
                l = mid + 1;
        }
        System.out.print(result); // 최종 결과: 최저 난이도
    }

    static boolean bfs() {
        visited = new boolean[N][N];
        q = new LinkedList<>();
        q.offer(new Hill(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Hill h = q.poll();
            int nowi = h.i;
            int nowj = h.j;
            if (nowi == N - 1 && nowj == N - 1) { // (l+r)/2로 정복 가능
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int nexti = nowi + di[d];
                int nextj = nowj + dj[d];
                if (isCheck(nexti, nextj) && !visited[nexti][nextj]) {
                    int slope = Math.abs(arr[nowi][nowj] - arr[nexti][nextj]); // 경사 계산
                    if (slope <= mid) { // mid까지 내리는게 가능하다면
                        visited[nexti][nextj] = true; // 좋아 가보자고
                        q.offer(new Hill(nexti, nextj));
                    }
                }
            }
        }
        return false; // 놉.
    }

    static boolean isCheck(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N;
    }

    static class Hill {
        int i, j;

        public Hill(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
