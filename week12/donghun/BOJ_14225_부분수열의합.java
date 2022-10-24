package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class week12_2_부분수열의합 {
    static int N;
    static int[] arr;
    static int[] out;
//    static TreeSet<Integer> set;
    static boolean[] visited;
    static boolean[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        out = new int[N];
        visited = new boolean[N];
        num = new boolean[20*100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);

        System.out.println(findZero());

    }

    static void subset(int idx) {
        if (idx == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum += out[i];
                }
            }
//            set.add(sum);
            num[sum] = true;
//            System.out.println(sum);

            return;
        }

        out[idx] = arr[idx];
        visited[idx] = true;
        subset(idx + 1); // 고른 경우
        visited[idx] = false;
        subset(idx + 1); // 고르지 않고 다음 idx로 넘긴 경우 (이번 idx는 빈 값 처리)
    }

    static int findZero() {
        for (int i = 1; i < 20*100001; i++) {
            if (!num[i]) {
                return i;
            }
        }
        return -1;
    }
}
