public class PROG_DP_leve3_정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.print(Solution(triangle));
	}
	
	static int Solution(int[][] triangle) {
		int len = triangle.length;
		
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				int A = 0;
				int B = 0;
				
				if(0 <= j-1 && j-1 < triangle[i-1].length) // 현재 위치 좌상단
					A = triangle[i-1][j-1];
				if(0 <= j && j < triangle[i-1].length) // 현재 위치 수직 상단
					B = triangle[i-1][j];
				
				triangle[i][j] += Math.max(A, B); // 둘 중 최댓값
			}
		}
		
		int max = 0;
		for(int e : triangle[len-1]) max = Math.max(max, e); // 마지막 줄 값 중 최댓값
		
		return max;
	}
}