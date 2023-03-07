package week26.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ 20125 : 쿠키의 신체측정 */
public class BOJ20125 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		int heartY = 0, heartX = 0;
		
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		FoundHeart:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == '*') {
					heartY = i + 1;
					heartX = j;
					break FoundHeart;
				}
			}
		}
		
		// lArm
		int lArm = 0;
		for (int j = heartX - 1; j >= 0; j--) {
			if (arr[heartY][j] != '*') break;
			lArm++;
		}
		
		// rArm
		int rArm = 0;
		for (int j = heartX + 1; j < n; j++) {
			if (arr[heartY][j] != '*') break;
			rArm++;
		}
		
		// waist
		int waist = 0;
		for (int i = heartY + 1; i < n; i++) {
			if (arr[i][heartX] != '*') break;
			waist++;
		}
		
		// lLeg
		int lLeg = 0;
		for (int i = heartY + waist + 1; i < n; i++) {
			if (arr[i][heartX - 1] != '*') break;
			lLeg++;
		}
		
		// rLeg
		int rLeg = 0;
		for (int i = heartY + waist + 1; i < n; i++) {
			if (arr[i][heartX + 1] != '*') break;
			rLeg++;	
		}
		
		System.out.println((heartY + 1) + " " + (heartX + 1));
		System.out.println(lArm + " " + rArm + " " + waist + " " + lLeg + " " + rLeg);
		
	}
}