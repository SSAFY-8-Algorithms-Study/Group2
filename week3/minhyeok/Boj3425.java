package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj3425 {

	static long[] stack;
	static int size;
	static boolean isError;
	static ArrayList<String> arr;
	static ArrayList<Long> nums;
	static int idx;
	static void execute(String oper) {
		if (isError) {
			return;
		} else if (oper.equals("NUM")) {
			long num = nums.get(idx);
			stack[size] = num;
			size++;
			idx++;
		} else if (oper.equals("POP")) {
			if (size < 1) {
				isError = true;
				return;
			}
			stack[--size] = 0;

		} else if (oper.equals("INV")) {
			if (size < 1) {
				isError = true;
				return;
			}
			stack[size - 1] = stack[size - 1] * -1;

		} else if (oper.equals("DUP")) {
			if (size < 1) {
				isError = true;
				return;
			}
			stack[size] = stack[size - 1];
			size++;

		} else if (oper.equals("SWP")) {
			if (size <= 1) {
				isError = true;
				return;
			} else {
				long temp = stack[size - 1];
				stack[size - 1] = stack[size - 2];
				stack[size - 2] = temp;
			}
		} else if (oper.equals("ADD")) {
			if (size <= 1) {
				isError = true;
				return;
			} else {
				stack[size - 2] = stack[size - 1] + stack[size - 2];
				stack[size - 1] = 0;
				size--;
				if (Math.abs(stack[size - 1]) > 1000000000) {
					isError = true;
					return;
				}
			}

		} else if (oper.equals("SUB")) {
			if (size <= 1) {
				isError = true;
				return;
			} else {
				stack[size - 2] = stack[size - 2] - stack[size - 1];
				stack[size - 1] = 0;
				size--;
				if (Math.abs(stack[size - 1]) > 1000000000) {
					isError = true;
					return;
				}
			}

		} else if (oper.equals("MUL")) {
			if (size <= 1) {
				isError = true;
				return;
			} else {
				long a = stack[size - 1];
				long b = stack[size - 2];
				long res = a * b;
				stack[size - 2] = res;
				stack[size - 1] = 0;
				size--;
				if (Math.abs(stack[size - 1]) > 1000000000) {
					isError = true;
					return;
				}
			}

		} else if (oper.equals("DIV")) {
			if (size <= 1 || stack[size - 1] == 0) {
				isError = true;
				return;
			} else {
				long a = stack[size - 2];
				long b = stack[size - 1];
				stack[size - 2] = a / b;
				if (Math.abs(stack[size - 2]) > 1000000000) {
					isError = true;
					return;
				}
				stack[size - 1] = 0;
				size--;
			}

		} else if (oper.equals("MOD")) {
			if (size <= 1 || stack[size - 1] == 0) {
				isError = true;
				return;
			} else {
				long a = stack[size - 2];
				long b = stack[size - 1];
				long res = a % b;
				stack[size - 2] = res;
				stack[size - 1] = 0;
				size--;
				if (Math.abs(stack[size - 1]) > 1000000000) {
					isError = true;
					return;
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new ArrayList<String>();
		nums = new ArrayList<Long>();
		while (true) {
			String[] str = br.readLine().split(" ");
			String oper = str[0];
			if (oper.equals("QUIT")) {
				break;
			}
			if (oper.equals("")) {
				continue;
			}
			if (oper.equals("NUM")) {
				nums.add(Long.parseLong(str[1]));
			}
			if (oper.equals("END")) {
				int N = Integer.parseInt(br.readLine());
				for (int i = 0; i < N; i++) {
					isError = false;
					stack = new long[1000];
					size = 0;
					long v = Long.parseLong(br.readLine());
					stack[size] = v;
					size++;
					idx=0;
					for (String a : arr) {
						execute(a);
					}
					if (size != 1) {
						isError = true;
					}
					if (isError) {
						System.out.println("ERROR");
					} else {
						System.out.println(stack[0]);
					}
				}
				System.out.println();
				arr = new ArrayList<String>();
				nums = new ArrayList<Long>();
			} else {
				arr.add(oper);
			}
		}
	}
}
