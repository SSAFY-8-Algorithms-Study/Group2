package week15.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ1956 : 운동 */
public class BOJ1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 플로이드 워셜(Floyd-Warshall Algorithm) :: 모든 정점에서 다른 모든 정점까지의 최단 경로 구하는 알고리즘
        long[][] graph = new long[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);	// 한 정점으로부터 다른 모든 정점까지의 거리를 Max 값으로 초기화
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        } // End Input

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= V; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);		// j -> k 정점으로 이동할 때, i 정점을 거쳐 가는 것이 더 최단 경로인지 판단해 거리값 갱신
                }
            }
        }

        // 가장 작은 사이클 체크
        long minCycle = Long.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            minCycle = Math.min(minCycle, graph[i][i]);	// i정점 -> i정점 가는 경우 = 사이클 발생
        }
        System.out.println(minCycle >= Integer.MAX_VALUE ? -1 : minCycle);
    }
}
