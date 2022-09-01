package boj;

import java.util.Scanner;

public class Boj2596 {
	static char[][] a = {
			{'0','0','0','0','0','0'}, // A
			{'0','0','1','1','1','1'}, // B
			{'0','1','0','0','1','1'}, // C
			{'0','1','1','1','0','0'}, // D
			{'1','0','0','1','1','0'}, // E
			{'1','0','1','0','0','1'}, // D
			{'1','1','0','1','0','1'}, // G
			{'1','1','1','0','1','0'} // H
			}; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 문자의 개수 
		String str = sc.next(); // 숫자 입력 
		sc.close();
		
		boolean isSelected = false; // 문자가 선택됐는지 확인 
		StringBuilder sb = new StringBuilder(); // 정답 
		for (int i=0; i<N*6; i+=6) { // 6개씩 끊어서 확인 
			isSelected = false;
			for (int n=0; n<8; n++) { // 8개 문자 비교 
				int error = 0; // 에러 카운트  
				char[] curChar = a[n]; // 현재 비교하고 있는 문자 
				for (int j=0; j<6; j++) { // 단어 하나 
					if (curChar[j] != str.charAt(i+j)) error++;
				}
				if (error <= 1) { // 에러 1 이하만 허용 
					sb.append((char) ('A'+n)); // 정답에 추가 
					isSelected = true; // 선택 확인 
				} 
			}
			if (!isSelected) {
				System.out.println(i/6+1); // 최초 모르는 문자가 들어온 위치 출력 
				break;
			}
		}
		if (isSelected) System.out.println(sb);
		
	}

}
