package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		
		for(int i = 0; i < 8; i++) {
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				if(str.charAt(j) == 'F') {
					if(i % 2 == 0 && j % 2 == 0) {
						result += 1;
					} else if(i % 2 != 0 && j % 2 != 0) {
						result += 1;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
