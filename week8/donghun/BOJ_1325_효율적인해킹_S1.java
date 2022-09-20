import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1325_효율적인해킹_S1 {
    static int N, M;
    static boolean[] visited;
    static int[] ans;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
        }
        // 입력 종료

//        for (int i=1; i<=N; i++) {
//            System.out.print(i+":");
//            for (int item : list[i]) {
//                System.out.print(item+" ");
//            }
//            System.out.println();
//        }

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        TreeSet<Integer> set = new TreeSet<>();
//        int ans = 1;
        ans = new int[N+1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i);
//            int tmp = bfs(i);
//            if (tmp > ans) {
//                set.clear();
//                set.add(i);
//                ans = tmp;
//            } else if (tmp == ans) {
//                set.add(i);
//            }
        }
//        System.out.println(Arrays.toString(ans));
        for (int i=1; i<=N; i++) {
            max = Math.max(max, ans[i]);
        }

//        System.out.println(max);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (max == ans[i]) {
                sb.append(i).append(" ");
            }
        }

//        for (Integer i : set) {
//            sb.append(i).append(" ");
//        }
        System.out.println(sb);
    }

    static void dfs(int v) {
        for (int i : list[v]) {
            if (visited[i])
                continue;
            ans[i]++;
            visited[i] = true;
            dfs(i);
        }
    }

//    static int bfs(int v) {
//        int count = 0;
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.add(v);
//        visited[v] = true;
//        count++;
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int s = 0; s < size; s++) {
//                int cur = q.poll();
//                for (int d = 0; d < list[cur].size(); d++) {
//                    if (!visited[list[cur].get(d)]) {
//                        q.add(list[cur].get(d));
//                        visited[list[cur].get(d)] = true;
//                        count++;
//                    }
//                }
//            }
//            count++;
//        }
//        return count;
//    }
}
