package week43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 유형 : 백트래킹 (완탐)
 * 시간 : 18m 15s
 */
public class B14620_꽃길 {
    static boolean[][] visited;
    static int answer;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;

        dfs(0, map, 0);

        System.out.println(answer);
    }
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, -1 ,1};
    static void dfs(int depth, int[][] map, int totalPrice){
        if(depth == 3){
            answer = Math.min(answer, totalPrice);
            return;
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(visited[i][j]) continue;
                if(visited[i-1][j] || visited[i][j+1] || visited[i+1][j] || visited[i][j-1]) continue;

                int price = map[i][j];
                visited[i][j] = true;
                for(int d=0; d<4; d++){
                    visited[ i + di[d] ][ j + dj[d] ] = true;
                    price += map[ i + di[d] ][ j + dj[d] ];
                }

                dfs(depth + 1, map, totalPrice + price);

                visited[i][j] = false;
                for(int d=0; d<4; d++){
                    visited[ i + di[d] ][ j + dj[d] ] = false;
                }
            }
        }
    }
}