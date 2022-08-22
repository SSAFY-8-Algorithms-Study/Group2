package boj;

import java.util.Scanner;

public class Boj2960 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stack = new int[N];  // 스택 사용하기 
		int size = 0; // 스택의 사이즈 
		for (int i=0;i<N;i++) {
			if (size == 0) { // 스택이 비어있으면 바로 추가 
				stack[size++] = sc.nextInt();
			} else {
				int curH = sc.nextInt();
				while (size>0) {
					if (stack[size-1]<=curH) { // 스택에 들어있는 막대기가 현재 막대기보다 작거나 같으면 아웃 
						stack[--size] = 0;
					} else break;
				}
				stack[size++] = curH;
			}
		}
		System.out.println(size);
		sc.close();
	}
}