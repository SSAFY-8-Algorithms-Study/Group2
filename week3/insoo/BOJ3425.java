package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * BOJ 3425 Gold 3
 * 고스택
 * 1. NUM 명령어 시에 입력 숫자를 numOfN에 저장
 * 2. 명령에 따른 조건 분기
 * 3. ArrayList 타입의 Stack을 사용
 * 4. 10^9 초과 처리를 위해 long형 사용
 */
public class BOJ3425 {
	static LinkedList<String> list; // 명령 리스트
	static LinkedList<Integer> numOfN; // NUM 명령어 숫자 리스트
	static StringBuilder sb;
	
	static void solv(int num) {
		ArrayList<Integer> stack = new ArrayList<>(); // Stack
		stack.add(num);
		int idxNumN = 0;
		for (int i = 0; i < list.size(); i++) {
			String command = list.get(i);
			int lastIdx = stack.size()-1;
			// 명령에 따른 조건 분기
			if(command.equals("NUM")) {
				stack.add(numOfN.get(idxNumN++));
			} else if(command.equals("POP")) {
				if(stack.size()<1) {
					sb.append("ERROR");
					break;
				}
				stack.remove(lastIdx);
			} else if(command.equals("INV")) {
				if(stack.size()<1) {
					sb.append("ERROR");
					break;
				}
				int temp = stack.get(lastIdx);
				stack.remove(lastIdx);
				stack.add(temp*-1);
			} else if(command.equals("DUP")) {
				if(stack.size()<1) {
					sb.append("ERROR");
					break;
				}
				stack.add(stack.get(lastIdx));
			} else if(command.equals("SWP")) {
				if(stack.size()<2) {
					sb.append("ERROR");
					break;
				}
				int fst = stack.get(lastIdx);
				stack.remove(lastIdx);
				int sec = stack.get(lastIdx-1);
				stack.remove(lastIdx-1);
				stack.add(fst);
				stack.add(sec);
			} else if(command.equals("ADD")) {
				if(stack.size()<2) {
					sb.append("ERROR");
					break;
				}
				long fst = stack.get(lastIdx);
				stack.remove(lastIdx);
				long sec = stack.get(lastIdx-1);
				stack.remove(lastIdx-1);
				long value = sec+fst;
				if(Math.abs(value) > 1000000000L) { // 10^9 초과 처리를 위해 long형 사용
					sb.append("ERROR");
					break;
				}
				stack.add((int)value);
			} else if(command.equals("SUB")) {
				if(stack.size()<2) {
					sb.append("ERROR");
					break;
				}
				long fst = stack.get(lastIdx);
				stack.remove(lastIdx);
				long sec = stack.get(lastIdx-1);
				stack.remove(lastIdx-1);
				long value = sec-fst;
				if(Math.abs(value) > 1000000000L) {
					sb.append("ERROR");
					break;
				}
				stack.add((int)value);
			} else if(command.equals("MUL")) {
				if(stack.size()<2) {
					sb.append("ERROR");
					break;
				}
				long fst = stack.get(lastIdx);
				stack.remove(lastIdx);
				long sec = stack.get(lastIdx-1);
				stack.remove(lastIdx-1);
				long value = sec*fst;
				if(Math.abs(value) > 1000000000L) {
					sb.append("ERROR");
					break;
				}
				stack.add((int)value);
			} else if(command.equals("DIV")) {
				if(stack.size()<2) {
					sb.append("ERROR");
					break;
				}
				int fst = stack.get(lastIdx);
				stack.remove(lastIdx);
				int sec = stack.get(lastIdx-1);
				stack.remove(lastIdx-1);
				if(fst==0) {
					sb.append("ERROR");
					break;
				}
				int negative = 1;
				if(fst<0) negative*=-1;
				if(sec<0) negative*=-1;
				stack.add(Math.abs(sec)/Math.abs(fst)*negative);
			} else if(command.equals("MOD")) {
				if(stack.size()<2) {
					sb.append("ERROR");
					break;
				}
				int fst = stack.get(lastIdx);
				stack.remove(lastIdx);
				int sec = stack.get(lastIdx-1);
				stack.remove(lastIdx-1);
				if(fst==0) {
					sb.append("ERROR");
					break;
				}
				int negative = 1;
				if(sec<0) negative*=-1;
				int value = Math.abs(sec)%Math.abs(fst)*negative;
				stack.add(value);
			} else if(command.equals("END")) {
				if(stack.size()!=1) {
					sb.append("ERROR");
					break;
				}
				else {
					sb.append(stack.get(0));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			sb = new StringBuilder();
			list = new LinkedList<>();
			numOfN = new LinkedList<>();
			
			while(true) {
				String str = br.readLine();
				// NUM 명령어 시에 입력 숫자를 numOfN에 저장
				if(str.startsWith("N")) {
					String[] strs = str.split(" ");
					str = strs[0];
					numOfN.offer(Integer.parseInt(strs[1]));
				}
				
				// QUIT 입력 시 종료
				if(str.equals("QUIT")) return;
				if(str.equals("END")) {
					list.offer(str);
					break;
				}
				list.offer(str);
			}
			// n줄의 숫자 입력
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				// 입력 숫자별 프로그램 수행
				solv(Integer.parseInt(br.readLine()));
				sb.append(System.lineSeparator());
			}
			br.readLine();
			
			System.out.println(sb);
		}
	}
}