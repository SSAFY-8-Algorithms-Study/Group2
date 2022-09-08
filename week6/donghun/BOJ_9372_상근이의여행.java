package week6.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의여행 {
    static int T, N, M;
    static ArrayList<Integer>[] listArray;
    static boolean[] visited;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = 0;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            listArray = new ArrayList[N];
            visited = new boolean[N];
            q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                listArray[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                listArray[start - 1].add(end - 1);
                listArray[end - 1].add(start - 1);
            }

            int _min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                _min = Math.min(_min, bfs(i));
            }

            System.out.println(_min);

//            for (int i = 0; i < N; i++) {
//                System.out.print(i+" Country: ");
//                for (int j = 0; j < listArray[i].size(); j++) {
//                    System.out.print(listArray[i].get(j)+" ");
//                }
//                System.out.println();
//            }
        }
    }

    static int bfs(int v) {
        q.add(v);
        visited[v] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int nV = q.poll();
                for (int d = 0; d < listArray[nV].size(); d++) {
                    int nextV = listArray[nV].get(d);
                    if (!visited[nextV]) {
                        visited[nextV] = true;
                        q.add(nextV);
                    }
                }
            }
            ans++;
            if (check()) return ans;
        }
        return -1;
    }

    static boolean check() {
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }
}
