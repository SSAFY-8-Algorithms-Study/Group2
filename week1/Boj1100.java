package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1100 {

	public static void main(String[] args) throws IOException{
		int N = 8;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0; // 총 체스판의 갯
		for (int i = 0;i<N;i++) {
			String row = br.readLine();
			for (int j=0; j<N;j++) {
				if (i%2==0 & j%2==0 & row.charAt(j)=='F') {
					cnt += 1;
				} else if (i%2==1 & j%2==1 & row.charAt(j)=='F') {
					cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
