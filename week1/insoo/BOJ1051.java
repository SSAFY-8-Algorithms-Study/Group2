import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		String[][] arr = new String[n][m];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().split("");
		}
		int area = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				String top_left = arr[i][j];
				for (int row = 1; row < m-j; row++) {
					if(i+row >= n) continue;
					if(top_left.equals(arr[i][j+row]) & top_left.equals(arr[i+row][j]) & top_left.equals(arr[i+row][j+row])) {
						area = Math.max(area, (row+1) * (row+1));
					}
				}
			}
		}
		System.out.print(area);
	}
}