import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static final int[] xDir = {-1, 0, 0, 1};
	static final int[] yDir = {0, -1, 1, 0};
	static int result = 0;
	
	public static int[][] checkNear(int[][] arr, int x, int y, int num, int cnt) {
		if(arr[x][y] > num) {
			// 확인한 영역 0으로 처리
			arr[x][y] = 0;
			// 영역 +1
			if(cnt == 0) result++;
			for (int iDir = 0; iDir < 4; iDir++) {
				int xx = x + xDir[iDir];
				int yy = y + yDir[iDir];
				
				// 4방 탐색 범위 벗어나는 것 처리
				if(xx < 0 | xx >= arr.length | yy < 0 | yy >= arr.length) {
					continue;
				}
				else {
					// 잠기지 않은 영역 중 인접 영역 구하기
					arr = checkNear(arr, xx, yy, num, 1);
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int area = 1;
		
		for (int i = 0; i < arr.length; i++) {
			String[] line = br.readLine().split(" ");
			for (int idx = 0; idx < line.length; idx++) {
				arr[i][idx] = Integer.parseInt(line[idx]);
			}
		}
		
		// 높이별로 구하기
		for (int num = 1; num < 100; num++) {
			// 2차원 배열의 깊은 복사
	        int[][] saved = new int[n][n];
	        for(int i=0; i<n; i++){
	            System.arraycopy(arr[i], 0, saved[i], 0, n);
	        }
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					checkNear(arr, i, j, num, 0);
				}
			}
			// 영역 체크로 인해 달라졌다면 arr 복구
			if(!arr.equals(saved)) {
		        for(int i=0; i<n; i++){
		            System.arraycopy(saved[i], 0, arr[i], 0, n);
		        }
			}
			// area와 이번 높이 안전 영역 갯수 중 최댓값
			area = Math.max(area, result);
			result = 0;
		}
		System.out.print(area);
	}
}
