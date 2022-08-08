package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean [][] arr = new boolean[101][101];
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int a=y;a<y+10;a++) {
				for (int b=x;b<x+10;b++) {
					arr[a][b] = true;
				}
			}
		}
		int sum=0;
		for (int i=1;i<101;i++) {
			for (int j=1;j<101;j++) {
				if (arr[i][j]) {
					sum += 1;
				}
			}
		}
		System.out.println(sum);
	}

}
