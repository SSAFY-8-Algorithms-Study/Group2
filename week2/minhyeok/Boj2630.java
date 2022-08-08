package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {
	
	static int white = 0;
	static int blue = 0;
	static int [][] arr;
	
	static boolean checkSquare(int y, int x, int n) {
		// Check n x n Size Square - White or Blue
		int sum = 0;
		for (int i=y;i<y+n;i++) {
			for (int j=x;j<x+n;j++) {
				sum += arr[i][j];
			}
		}
		
		if (sum == n*n) {
			blue +=1;
			return true;
		}
		
		if (sum == 0) {
			white +=1;
			return true;
		}
		return false;
	}
	
	static void dfs(int y,int x,int n) {
		if (checkSquare(y,x,n)) {
			return;
		}
		dfs(y,x,n/2);
		dfs(y+n/2,x,n/2);
		dfs(y,x+n/2,n/2);
		dfs(y+n/2,x+n/2,n/2);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		dfs(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}

}
