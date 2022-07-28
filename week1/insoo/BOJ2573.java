import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

class Main {
	static final int[] xDir = {-1, 0, 0, 1};
	static final int[] yDir = {0, -1, 1, 0};
	static int result = 0;
	static int year = 0;

	public static void checkNear(int[][] arr, int x, int y, int cnt) {
		if(arr[x][y] > 0) {
			// 확인한 영역 0으로 처리
			arr[x][y] = 0;
			// 영역 +1
			if(cnt == 0) result++;
			for (int iDir = 0; iDir < 4; iDir++) {
				int xx = x + xDir[iDir];
				int yy = y + yDir[iDir];
				
				// 4방 탐색 범위 벗어나는 것 처리
				if(xx < 0 | xx >= arr.length | yy < 0 | yy >= arr[0].length) {
					continue;
				}
				else {
					// 잠기지 않은 영역 중 인접 영역 구하기
					checkNear(arr, xx, yy, 1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int[][] arr = new int[n][m];
		int[][] subArr = new int[n][m];

		for(int i=0; i<n; i++) {
			String[] strs = br.readLine().split(" ");
			for (int j=1; j<m; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		while(true) {
			year++;
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if(arr[i][j] > 0) {
						int subCnt = 0;
						for (int iDir = 0; iDir < 4; iDir++) {
							int x = i + xDir[iDir];
							int y = j + yDir[iDir];
							
							// 4방 탐색 범위 벗어나는 것 처리
							if(x < 0 | x >= n | y < 0 | y >= m) {
								continue;
							}
							else {
								if(arr[x][y] == 0) {
									subCnt++;
								}
							}
						}
						subArr[i][j] = subCnt;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j] > 0) {
						arr[i][j] -= subArr[i][j];
						if(arr[i][j] < 0) arr[i][j] = 0;						
					}
				}
			}
			
			// 2차원 배열의 깊은 복사
	        int[][] saved = new int[n][m];
	        for(int i=0; i<n; i++){
	            System.arraycopy(arr[i], 0, saved[i], 0, m);
	        }

			// 이어진 빙하 검사
	        int isEmpty = 0;
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if(arr[i][j] > 0) {
						checkNear(arr, i, j, 0);
						isEmpty++;
					}
				}
			}
			if(isEmpty==0) {
				year = 0;
				break;
			}
			// 영역 체크로 인해 달라졌다면 arr 복구
			if(!arr.equals(saved)) {
		        for(int i=0; i<n; i++){
		            System.arraycopy(saved[i], 0, arr[i], 0, m);
		        }
			}
			if(result > 1) break;
			else result = 0;
		}
		System.out.print(year);
	}
}