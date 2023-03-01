package week25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13549_숨바꼭질3 {
    /**
     * https://www.acmicpc.net/problem/13549
     * 백준 13549 : 숨바꼭질 3
     * BFS? 최단 시간..
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수빈
        int K = Integer.parseInt(st.nextToken());   // 동생

        int[] D = new int[100001];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[N] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()){
            int now = q.poll();
            if(now == K) break;

            // +1
            if(now >= 0 && now < 100000){
                if(D[now + 1] > D[now] + 1){
                    D[now + 1] = D[now] + 1;
                    q.add(now + 1);
                }
            }

            // -1
            if(now > 0 && now <= 100000){
                if(D[now - 1] > D[now] + 1){
                    D[now - 1] = D[now] + 1;
                    q.add(now - 1);
                }
            }

            //순간이동
            if(now * 2 > 100000) continue;
            if(D[now * 2] > D[now]){
                D[now * 2] = D[now];
                q.add(now * 2);
            }
        }

        System.out.println(D[K]);
    }
}