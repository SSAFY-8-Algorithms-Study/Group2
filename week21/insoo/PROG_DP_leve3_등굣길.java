public class PROG_DP_leve3_등굣길 {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		
		System.out.print(Solution(m,n,puddles));
	}
	
	static int DIV = 1_000_000_007; // 나누기 피연산자
	
	static int Solution(int m, int n, int[][] puddles) {
        int DIV = 1_000_000_007; // 나누기 피연산자
        int[] nDir = {0, -1}; // 좌상단
        int[] mDir = {-1, 0}; // 수직 상단
        
        int[][] dp = new int[n][m];
		dp[0][0] = 1; // 시작점 1
		
		for(int[] p : puddles) dp[p[1]-1][p[0]-1] = -1; // 물에 잠긴 곳 기록
		
		for (int nowN = 0; nowN < dp.length; nowN++) {
			for (int nowM = 0; nowM < dp[nowN].length; nowM++) {
				if(dp[nowN][nowM] == -1) continue; // 물에 잠긴 곳 스킵
				
				for (int d = 0; d < 2; d++) {
					int nextN = nowN + nDir[d]; // 현재 기준 좌상단, 수직상단
					int nextM = nowM + mDir[d];
					
					if(0<=nextN && nextN<n && 0<=nextM && nextM<m && dp[nextN][nextM] != -1) {
						dp[nowN][nowM] = (dp[nowN][nowM] + dp[nextN][nextM]) % DIV; // 수시로 나눠주기
					}
				}
			}
		}
		
		return dp[n-1][m-1];
	}
}