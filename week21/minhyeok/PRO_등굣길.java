class Solution {
    /*
        처음부터 왼쪽과 위쪽에서 올 수 있는 모든 경우의 수를 더한다.
    */
    public int solution(int m, int n, int[][] puddles) {
        // 웅덩이 체크
        boolean[][] isPuddle = new boolean[m][n];
        for (int[] puddle : puddles) {
            isPuddle[puddle[0]-1][puddle[1]-1] = true;
        }
        
        // 모든 경로 경우의 수 누적합 
        int[][] dp = new int[m][n];
        dp[0][0] = 1; // 출발지
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i-1 < 0 && j-1 < 0) continue;
                
                if (j-1 >= 0 && !isPuddle[i][j-1]) { // 왼쪽 체크
                    dp[i][j] += dp[i][j-1];
                }
                if (i-1 >= 0 && !isPuddle[i-1][j]) { // 위쪽 체크 
                    dp[i][j] += dp[i-1][j];
                }
                dp[i][j] %= 1000000007;
            }
        }
        return dp[m-1][n-1];
    }
}