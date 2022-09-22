package baekjoon;

import java.util.Scanner;

public class B10162전자레인지 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[3];
		
		if(N >= 300) {
			arr[0] = N / 300;
			N = N % 300;
		}
		if(N >= 60) {
			arr[1] = N / 60;
			N = N % 60;
		}
		if(N >= 10){
			arr[2] = N / 10;
			N = N % 10;
		}
		if(N != 0 && N < 10) {
			System.out.println(-1);
			return;
		}

		for(int i=0; i<3; i++) {
			System.out.print(arr[i] + " ");
		}
			
	}
}
