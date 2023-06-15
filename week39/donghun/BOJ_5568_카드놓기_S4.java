package donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_5568_카드놓기_S4 {
    static int N, K;
    static int[] card;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        card = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }

        permutation("", 0);

        System.out.println(set.size());
    }

    static void permutation(String num, int depth) {
        if (depth == K) {
            set.add(num);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(num + card[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}