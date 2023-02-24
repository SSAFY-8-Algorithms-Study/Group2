package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B23971_ZOAC4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());	// i
		int W = Integer.parseInt(st.nextToken());	// j
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int nowi = 1;
		int nowj = 1;
		
		int ans1 = 0;
		int ans2 = 0;

		while(nowi <= H) {
			ans1++;
			nowi = nowi + (N + 1);
		}
		while(nowj <= W) {
			ans2++;
			nowj = nowj + (M + 1);
		}
		
		System.out.print(ans1 * ans2);
	}
}
