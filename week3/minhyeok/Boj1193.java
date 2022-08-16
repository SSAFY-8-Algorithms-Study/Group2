package boj;

import java.util.Scanner;

public class Boj1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = 1; // Current Level
		int sum = 0; // Sum of Levels
		while (true) {
			if (sum+l>=n) { // Check n's Level
				break;
			}
			sum += l++;
		}
		int sNum = sum+1; // Start Number of Level l
		if (l%2==0) {
			int first = 1;
			int last = l;
			for (int i=0;i<l;i++) {
				if (sNum+i==n) {
					System.out.println((first+i) +"/"+(last-i));
				}
			}
		} else {
			int first = l;
			int last = 1;
			for (int i=0;i<l;i++) {
				if (sNum+i==n) {
					System.out.println((first-i) +"/"+(last+i));
				}
		}
	}
}
}