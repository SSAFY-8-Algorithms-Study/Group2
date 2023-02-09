package week22.seoyoon;

import java.util.ArrayList;

public class PRO_네트워크 {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(3, computers));
    }

    public static int solution(int n, int[][] computers) {
        adjList = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        dfs(0);
        return answer;
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        answer++;

        for (Integer idx : adjList[cur]) {
            if (visited[idx] == true) continue;
            dfs(idx);
        }
    }

}
