package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1459_걷기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//집의 위치
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		
		//걸리는 시간
		long W = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());

		long sum = 0;
		if(W * 2 > S) {	// 대각선이 더 유리 하면
			//더 작은거 까지 대각선으로 가기
			if(Y > X) {
				sum += X * S;
	
			}else {
				sum += Y * S;

			}
			long temp = Math.abs(Y - X);	//나머지 계산
			if(temp >= 2) {
				if(W > S) {
					sum += ((temp / 2) * S) * 2;
					sum += (temp % 2) * W;
				}else {
					sum += temp * W;
				}
			}else {
				sum += (W * temp);
			}
			
		}else {	// 걷는 것이 더 유리함?
			//대각선으로 가느니 두번 걸어가는게 이득.
			sum += (X + Y) * W;
		}
		System.out.println(sum);
	}
}
