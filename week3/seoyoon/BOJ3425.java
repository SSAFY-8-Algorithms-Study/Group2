package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BOJ3425 {

    static List<String> programList;
    static Stack<Long> stack;
    static boolean error;
    static int MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            programList = new LinkedList<>();

            while (true) {     // 프로그램 저장
                String str = br.readLine();

                if (str.equals("QUIT")) return;
                if (str.equals("END")) break;

                if (str.contains("NUM")) {
                    String[] tmp = str.split(" ");
                    programList.add(tmp[1]);    // 명령어로 NUM이 입력될 시 숫자 값만 저장
                }
                else {
                    programList.add(str);
                }
            }

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                execProgram(Long.parseLong(br.readLine()));     // 입력 영역
            }
            br.readLine();
            System.out.println();
        }
    }

    public static void execProgram(long input) {
        stack = new Stack<>();
        stack.push(input);
        error = false;

        for (int i = 0; i < programList.size(); i++) {
            program(stack, programList.get(i));     // 각각의 입력값에 대해서 저장되어 있는 모든 프로그램 수행
        }

        if (error || stack.size() != 1) {
            System.out.println("ERROR");
            return;
        }

        System.out.println(stack.peek());
    }

    public static void program(Stack stack, String order) {
        long num1 = -1, num2 = -1;
        switch (order) {
            case "POP":
                if (stack.isEmpty()) {
                    error = true;
                    break;
                }
                stack.pop();
                break;

            case "INV":
                if (stack.isEmpty()) {
                    error = true;
                    break;
                }
                stack.push((long)stack.pop() * -1);
                break;

            case "DUP":
                if (stack.isEmpty()) {
                    error = true;
                    break;
                }
                stack.push(stack.peek());
                break;

            case "SWP":
                if (stack.size() >= 2) {
                    num1 = (long) stack.pop();
                    num2 = (long) stack.pop();
                    stack.push(num1);
                    stack.push(num2);
                }
                else error = true;
                break;

            case "ADD":
                if (stack.size() >= 2) {
                    num1 = (long) stack.pop();
                    num2 = (long) stack.pop();

                    if (Math.abs(num1 + num2) > MAX) {      // 연산의 결과가 10^9 보다 큰 경우 error
                        error = true;
                        break;
                    }
                    stack.push(num1 + num2);
                }
                else error = true;
                break;

            case "SUB":
                if (stack.size() >= 2) {
                    num1 = (long) stack.pop();
                    num2 = (long) stack.pop();

                    if (Math.abs(num2 - num1) > MAX) {
                        error = true;
                        break;
                    }
                    stack.push(num2 - num1);
                }
                else error = true;
                break;

            case "MUL":
                if (stack.size() >= 2) {
                    num1 = (long) stack.pop();
                    num2 = (long) stack.pop();

                    if (Math.abs(num1 * num2) > MAX) {
                        error = true;
                        break;
                    }
                    stack.push(num1 * num2);
                }
                else error = true;
                break;

            case "DIV":
                if (stack.size() >= 2) {
                    num1 = (long) stack.pop();
                    num2 = (long) stack.pop();

                    if (num1 == 0) {
                        error = true;
                        break;
                    }
                    long num = Math.abs(num2) / Math.abs(num1);

                    if ((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
                        num *= -1;
                    }
                    stack.push(num);
                }
                else error = true;
                break;

            case "MOD":
                if (stack.size() >= 2) {
                    num1 = (long) stack.pop();
                    num2 = (long) stack.pop();

                    if (num1 == 0) {
                        error = true;
                        break;
                    }
                    long num = Math.abs(num2) % Math.abs(num1);

                    if (num2 < 0) {
                        num *= -1;
                    }
                    stack.push(num);
                }
                else error = true;
                break;

            default:    // NUM X 인 경우
                stack.push(Long.parseLong(order));
        }
    }
}
