class Solution {    
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr = new int[triangle.length][triangle.length];
        int[][] dp = new int[triangle.length][triangle.length];
        
        for(int i = 0; i < triangle.length; i++) {
            for(int j = i, idx = 0; j < triangle.length; j++, idx++) {
                arr[idx][i] = triangle[j][i];
            }
        }
        
        dp[0][0] = arr[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            dp[0][i] = arr[0][i] + dp[0][i - 1];
            dp[i][0] = arr[i][0] + dp[i - 1][0];
        }
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 1; j < triangle.length; j++) {
                dp[i][j] = Math.max((arr[i][j] + dp[i][j - 1]), (arr[i][j] + dp[i - 1][j]));
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer;
    }
}