package week25.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class BOJ10431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TESTCASE; tc++) {
            int cnt = 0;
            String[] students = br.readLine().split(" ");
            Stack<Integer> stack = new Stack<Integer>();
            for (int i=1; i<21; i++) {
                // 현재 학생의 키
                int curHeight = Integer.parseInt(students[i]);

                // 자신보다 큰 키의 학생이 있으면 뒤로 물러서기
                ArrayDeque<Integer> temp = new ArrayDeque<Integer>();
                while (!stack.isEmpty() && stack.peek() > curHeight) {
                    temp.addFirst(stack.pop());
                    cnt++;
                }

                // 줄 서기
                stack.add(curHeight);

                // 물러난 학생들 다시 스택에 채우기
                if (!temp.isEmpty()) stack.addAll(temp);
            }
            System.out.println(students[0]+" "+cnt);
        }
    }
}
