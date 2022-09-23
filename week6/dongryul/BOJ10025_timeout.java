package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10025게으른백곰_시간초과 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] x = new int[1000001]; 
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int inputG = Integer.parseInt(st.nextToken());
			int inputX = Integer.parseInt(st.nextToken());
			
			for(int dx= -K; dx <= K; dx++) {
				if(inputX + dx < 0 || inputX + dx > 1000000) {	// x좌표가 양수일때만
					continue;
				}
				x[inputX + dx] += inputG;
			}
		}
		System.out.println(Arrays.stream(x).max().getAsInt());
	}
}
