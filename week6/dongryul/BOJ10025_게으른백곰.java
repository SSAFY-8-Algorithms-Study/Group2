package test;

import java.util.Scanner;

public class B10025 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		arr = new int[1000001];
		for(int n=0; n<N; n++) {
			int g = sc.nextInt();
			int x = sc.nextInt();
			
			arr[x] = g;
		}
		long sum = 0;
		long max = 0;
		
		if(K > 1000000) {
			for(int i=0; i<=1000000; i++) {
				sum += arr[i];
			}
			System.out.println(sum);
			return;
		}else {
			//처음 윈도우
			for(int k=0; k<=K*2; k++) {	// 좌표 1부터 시작
				if(k == 1000001) {			//x 범위 넘어가면 break;
					break;
				}
				sum += arr[k];
			}
			max = sum;		//max value mapping;
			
			//슬라이딩 윈도우
			for(int k = K; k<= 1000000; k++) {
				sum -= arr[k - K];		//앞에 것 빼주고
				if(k + K+1 <= 1000000) {
					sum += arr[k + (K+1)];	// 뒤에 것 더해준다.
				}else {
					break;
				}
				max = Math.max(sum, max);
			}
		}
		System.out.println(max);
	}
}
