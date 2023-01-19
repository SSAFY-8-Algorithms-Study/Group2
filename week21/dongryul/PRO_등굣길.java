package programmers.dp;

import java.util.Arrays;

public class PRO_등굣길 {
	int[][] D;
    int[][] map;
    int N, M;
    int[] di = {1, 0};
    int[] dj = {0, 1};
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        N = n;
        M = m;
        map = new int[N][M];
        int[][] C = new int[N][M];
        D = new int[N][M];
        
        for(int i=0; i<N; i++){
            Arrays.fill(D[i], 10000000);
        }
        D[0][0] = 0;
        
        // 물 웅덩이
        for(int[] puddle : puddles){
            map[puddle[1] - 1][puddle[0] - 1] = 1;
        }
        
        C[0][0] = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int d=0; d<2; d++){
                    int nexti = i + di[d];
                    int nextj = j + dj[d];
                    
                    if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
                    if(map[nexti][nextj] == 1) continue;

                    if(D[nexti][nextj] >= D[i][j] + 1){
                        D[nexti][nextj] = D[i][j] + 1;
                        C[nexti][nextj] += C[i][j];
                        
                        // 이거 왜 효율성...???
                        if(C[nexti][nextj] >= 1000000007){
                            C[nexti][nextj] %= 1000000007;
                        }
                    }
                }
            }
        }
        answer = C[N-1][M-1];
        
        return answer;
    }
}
