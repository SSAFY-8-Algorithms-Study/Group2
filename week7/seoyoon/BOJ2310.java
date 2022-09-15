package week7.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ 2310 : 어드벤처 게임 */
public class BOJ2310 {

    static class room {
        int idx;
        char ch;
        int price;
        ArrayList<Integer> connected;

        public room(int idx, char ch, int price, ArrayList<Integer> connected) {
            this.idx = idx;
            this.ch = ch;
            this.price = price;
            this.connected = connected;
        }
    }

    static boolean[] visited;
    static room[] miro;
    static int n, money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            visited = new boolean[n + 1];
            miro = new room[n + 1];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                int price = Integer.parseInt(st.nextToken());

                ArrayList<Integer> connected = new ArrayList<>();
                while(st.hasMoreTokens()) {
                    connected.add(Integer.parseInt(st.nextToken()));
                }
                connected.remove(connected.size() - 1);     // 마지막 0 제거
                miro[i] = new room(i, ch, price, connected);
            }
            // End Input
            bfs();
        }
    }

    public static void bfs() {
        if (miro[1].ch == 'T') {
            System.out.println("No");
            return;
        }

        Deque<room> q = new ArrayDeque<>();
        q.offer(miro[1]);
        visited[1] = true;

        while (!q.isEmpty()) {
            room cur = q.poll();
            visited[cur.idx] = true;

            if (cur.ch == 'L') {
                if (money < cur.price) {
                    money = cur.price;
                }
            }
            else if (cur.ch == 'T') {
                if (money >= cur.price) {
                    money -= cur.price;
                }
                else {
                    // 돈이 모자라면 못감
                    visited[cur.idx] = false;
                    continue;
                }
            }
            if (visited[n]) {
                System.out.println("Yes");
                return;
            }

            for (int i = 0; i < cur.connected.size(); i++) {
                if (visited[cur.connected.get(i)]) continue;
                q.offer(miro[cur.connected.get(i)]);
            }
        }
        System.out.println("No");
        return;
    }
}
