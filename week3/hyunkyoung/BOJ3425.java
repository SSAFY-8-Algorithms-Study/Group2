package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ3425 { // 고스택
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<String> order = new ArrayList<>(); // 명령 리스트
		stack = new Stack<>();
		
		String str ="";
		while(!(str = br.readLine()).equals("QUIT")) {
			if(str.equals("")) continue;
			
			if(!str.equals("END")) {
				order.add(str); // 첫 명령 저장
				while(!(str = br.readLine()).equals("END")) {
					order.add(str); // 다음 명령 저장
				}
			}
			
			int N = Integer.parseInt(br.readLine()); // 수행 횟수
			for(int n = 0; n < N; n++) {
				stack.add(Integer.parseInt(br.readLine()));
				
				boolean error = false;
				for(int i = 0; i < order.size(); i++) {
					if(program(order.get(i)) == 1) { // 프로그램 에러
						error = true;
						break;
					}
				}
				
				if(error == true || stack.size() != 1) {
					sb.append("ERROR").append('\n');
					stack.clear();
				} else {
					sb.append(stack.pop()).append('\n');
				}
			}
			
			order.clear();
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int program(String str) {
		int num1 = 0, num2 = 0;
		
		if(str.startsWith("NUM")) {
			num1 = Integer.parseInt(str.split(" ")[1]);
			stack.add(num1);
			return 0;
		}
		
		if(!str.equals("POP") && !str.equals("INV") && !str.equals("DUP")) {
			if(stack.size() <= 1) return 1;
		} else if(str.equals("POP") || str.equals("INV") || str.equals("DUP")) {
			if(stack.size() == 0) return 1;
		}
		
		switch(str) {
		case "POP": // 첫번째 숫자 제거
			stack.pop();
			break;
		case "INV": // 첫번째 숫자 부호 변경
			num1 = stack.pop();
			stack.add(-num1);
			break;
		case "DUP": // 첫번째 숫자 하나 더 저장
			num1 = stack.peek();
			stack.add(num1);
			break;
		case "SWP": // 첫번째 숫자 <-> 두번째 숫자
			num1 = stack.pop();
			num2 = stack.pop();
			stack.add(num1);
			stack.add(num2);
			break;
		case "ADD": // 첫번째 숫자 + 두번째 숫자
			num1 = stack.pop();
			num2 = stack.pop();
			if(num1 + num2 > 1000000000) return 1;
			stack.add(num1 + num2);
			break;
		case "SUB": // 두번째 숫자 - 첫번째 숫자
			num1 = stack.pop();
			num2 = stack.pop();
			if(num2 - num1 < -1000000000) return 1;
			stack.add(num2 - num1);
			break;
		case "MUL": // 첫번째 숫자 * 두번째 숫자
			num1 = stack.pop();
			num2 = stack.pop();
			if(Math.abs((long) num1 * num2) > 1000000000) return 1;
			stack.add(num1 * num2);
			break;
		case "DIV": // 두번째 숫자 / 첫번째 숫자
			num1 = stack.pop();
			num2 = stack.pop();
			if(num1 == 0) return 1;
			stack.add(num2 / num1);
			break;
		case "MOD": // 두번째 숫자 % 첫번째 숫자
			num1 = stack.pop();
			num2 = stack.pop();
			if(num1 == 0) return 1;
			stack.add(num2 % num1);
			break;
		}
		
		return 0;
	}
}
