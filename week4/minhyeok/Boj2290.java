package boj;

import java.util.Scanner;

public class Boj2290 {
	static int s;
	static String n;
	static final String space = " "; // 공백 (서윤님이 고스택 문제에서 max값을 저장해 놓은 방법을 사용해봤습니다)
	static final String vBar = "|"; // 길이 1의 세로선
	static final String hBar = "-"; // 길이 1의 가로선
	
	static interface DigitNumber { // 모든 숫자 클래스가 상속할 인터페이스입니다.
		
		public default String hatOn() { // size만큼 수평선 (모자를 쓴 것 같아서 이름을 이렇게 지었어요 ㅎㅎ)
			StringBuilder sb = new StringBuilder();
			sb.append(space);
			for (int i = 0; i < s; i++) { // size만큼 가로선이 들어갑니다
				sb.append(hBar);
			}
			sb.append(space);
			return sb.toString();
		};
		
		public default String empty() { // size만큼 공백이 들어갑니다. 
			StringBuilder sb = new StringBuilder();
			sb.append(space);
			for (int i = 0; i < s; i++) {
				sb.append(space);
			}
			sb.append(space);
			return sb.toString();
		};
		
		public default String lrBar() { // 왼쪽과 오른쪽 사이드에 세로선이 있습니다.
			StringBuilder sb = new StringBuilder();
			sb.append(vBar);
			for (int i = 0; i < s; i++) {
				sb.append(space);
			}
			sb.append(vBar);
			return sb.toString();
		};
		
		public default String rBar() { // 오른쪽에 세로선이 있습니다. 
			StringBuilder sb = new StringBuilder();
			sb.append(space);
			for (int i = 0; i < s; i++) {
				sb.append(space);
			}
			sb.append(vBar);
			return sb.toString();
		};
		
		public default String lBar() { // 왼쪽에 세로선이 있습니다.
			StringBuilder sb = new StringBuilder();
			sb.append(vBar);
			for (int i = 0; i < s; i++) {
				sb.append(space);
			}
			sb.append(space);
			return sb.toString();
		};
		// 상속 받은 숫자 클래스에서 구현할 메서드들입니다.
		public String getHeader(); // 헤더 부분
		public String getFirstBody(); // 바디의 첫 부분
		public String getSecondBody(); // 바디의 두번째 부분
		public String getThirdBody(); // 바디의 세번째 부분
		public String getFooter(); // 마지막 부분 
	}
	
	static class Zero implements DigitNumber{ // 숫자 0
		
		@Override
		public String getHeader() {
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			return lrBar();
		}

		@Override
		public String getSecondBody() {
			return empty();
		}

		@Override
		public String getThirdBody() {
			// TODO Auto-generated method stub
			return this.lrBar();
		}

		@Override
		public String getFooter() {
			// TODO Auto-generated method stub
			return this.hatOn();
		}
		
	}
	
	static class One implements DigitNumber { // 숫자 0

		@Override
		public String getHeader() {
			return empty();
		}

		@Override
		public String getFirstBody() {
			return rBar();
		}

		@Override
		public String getSecondBody() {
			return empty();
		}

		@Override
		public String getThirdBody() {
			return rBar();
		}

		@Override
		public String getFooter() {
			return empty();
		}

		
		
	}
	
	static class Two implements DigitNumber { // 숫자 2

		@Override
		public String getHeader() {
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			// TODO Auto-generated method stub
			return rBar();
		}

		@Override
		public String getSecondBody() {
			// TODO Auto-generated method stub
			return hatOn();
		}

		@Override
		public String getThirdBody() {
			// TODO Auto-generated method stub
			return lBar();
		}

		@Override
		public String getFooter() {
			// TODO Auto-generated method stub
			return hatOn();
		}
		
	}
	
	static class Three implements DigitNumber{ // 숫자 3

		@Override
		public String getHeader() {
			// TODO Auto-generated method stub
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			// TODO Auto-generated method stub
			return rBar();
		}

		@Override
		public String getSecondBody() {
			// TODO Auto-generated method stub
			return hatOn();
		}

		@Override
		public String getThirdBody() {
			// TODO Auto-generated method stub
			return rBar();
		}

		@Override
		public String getFooter() {
			// TODO Auto-generated method stub
			return hatOn();
		}
		
	}
	
	static class Four implements DigitNumber { // 숫자 4

		@Override
		public String getHeader() {
			return empty();
		}

		@Override
		public String getFirstBody() {
			return lrBar();
		}

		@Override
		public String getSecondBody() {
			return hatOn();
		}

		@Override
		public String getThirdBody() {
			return rBar();
		}

		@Override
		public String getFooter() {
			return empty();
		}
		
	}
	
	static class Five implements DigitNumber { // 숫자 5

		@Override
		public String getHeader() {
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			return lBar();
		}

		@Override
		public String getSecondBody() {
			return hatOn();
		}

		@Override
		public String getThirdBody() {
			return rBar();
		}

		@Override
		public String getFooter() {
			return hatOn();
		}
	}
	
	static class Six implements DigitNumber { // 숫자 6

		@Override
		public String getHeader() {
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			return lBar();
		}

		@Override
		public String getSecondBody() {
			return hatOn();
		}

		@Override
		public String getThirdBody() {
			return lrBar();
		}

		@Override
		public String getFooter() {
			return hatOn();
		}
		
	}
	
	static class Seven implements DigitNumber { // 숫자 7

		@Override
		public String getHeader() {
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			return rBar();
		}

		@Override
		public String getSecondBody() {
			return empty();
		}

		@Override
		public String getThirdBody() {
			return rBar();
		}

		@Override
		public String getFooter() {
			return empty();
		}
		
	}
	
	static class Eight implements DigitNumber { // 숫자 8

		@Override
		public String getHeader() {
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			return lrBar();
		}

		@Override
		public String getSecondBody() {
			return hatOn();
		}

		@Override
		public String getThirdBody() {
			return lrBar();
		}

		@Override
		public String getFooter() {
			return hatOn();
		}
		
	}
	
	static class Nine implements DigitNumber { // 숫자 9

		@Override
		public String getHeader() {
			return hatOn();
		}

		@Override
		public String getFirstBody() {
			return lrBar();
		}

		@Override
		public String getSecondBody() {
			return hatOn();
		}

		@Override
		public String getThirdBody() {
			return rBar();
		}

		@Override
		public String getFooter() {
			return hatOn();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt(); // 사이즈
		n = sc.next(); // 표시해야할 숫자 
		char [] arr = n.toCharArray(); // 입력받은 숫자를 char 배열로 만듭니다. 
		DigitNumber[] numbers = {new Zero(), new One(), new Two(), new Three(), new Four(), new Five(), new Six(), new Seven(), new Eight(), new Nine()}; // 0~9 숫자 객체들입니다
		// Print Header
		for (char num : arr) {
				DigitNumber dNum = numbers[num-'0']; // 숫자 객체들의 배열의 인덱스와 숫자를 일치시켜 참조합니다.
				System.out.print(dNum.getHeader());
				System.out.print(" ");
		}
		System.out.println();
		// Print First Body
		for (int i = 0; i < s; i++) {
			for (char num : arr) {
				DigitNumber dNum = numbers[num-'0'];
				System.out.print(dNum.getFirstBody());
				System.out.print(" ");
			}
			System.out.println();
		}
		// Print Second Body
		for (char num : arr) {
			DigitNumber dNum = numbers[num-'0'];
			System.out.print(dNum.getSecondBody());
			System.out.print(" ");
		}
		System.out.println();
		// Print Third Body
		for (int i = 0; i < s; i++) {
			for (char num : arr) {
				DigitNumber dNum = numbers[num-'0'];
				System.out.print(dNum.getThirdBody());
				System.out.print(" ");
			}
			System.out.println();
		}
		// Print Footer
		for (char num : arr) {
			DigitNumber dNum = numbers[num-'0'];
			System.out.print(dNum.getFooter());
			System.out.print(" ");
		}
		sc.close();
		}
	}

