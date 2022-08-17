package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 { // 분수찾기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int num = 1, cnt = 1;
		while(true) {
			if(num >= X) {
				break;
			}
			
			cnt += 1;
			num += (cnt);
		}
		
		int up = 0, down = 0;
		if(cnt % 2 == 1) {
			down = cnt - (num - X);
			up = (cnt + 1) - down;
		} else {
			up = cnt - (num - X);
			down = (cnt + 1) - up;
		}
		
		System.out.println(up + "/" + down);
	}
}
