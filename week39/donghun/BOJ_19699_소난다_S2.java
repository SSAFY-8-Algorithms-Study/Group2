package donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19699_소난다_S2 {
    static int N, M;
    static int[] cows;
    static boolean[] visited;
    static Set<Integer> primeWeights;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        primeWeights = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cows = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 정렬
        List<Integer> result = new ArrayList<>(primeWeights);
        Collections.sort(result);

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int weight : result) {
                sb.append(weight).append(" ");
            }
            System.out.println(sb);
        }
    }

    // 재귀 드가자
    static void dfs(int depth, int sum) {
        if (depth == M) {
            if (isPrime(sum)) {
                primeWeights.add(sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + cows[i]);
                visited[i] = false;
            }
        }
    }

    // 에라토스테네스
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}