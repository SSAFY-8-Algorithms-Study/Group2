package week3.donghun;

import java.util.*;

public class BOJ_3425_고스택 {
    static Stack<Integer> stack;
    static Queue<String> op;
    static Queue<Integer> num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        stack = new Stack<Integer>();
        op = new LinkedList<String>();

        // operator 입력
        while (!(sc.nextLine().equals("END"))) {
            {
                op.add(sc.nextLine());
            }

            // operend 입력
            while (!(sc.nextLine().equals(""))) {
                num.add(sc.nextInt());
//                System.out.print("여기 뭐래냐?:"+Integer.parseInt(sc.nextLine()));
            }

            System.out.println(op);
            System.out.println(num);

        }
    }

    void NUM(int X) {
        stack.push(X);
    }
    void POP() {
        stack.pop();
    }
    void INV() {
        stack.push(-stack.pop());
    }
    void DUP() {
        stack.push(stack.peek());
    }
    void SWP() {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(first);
        stack.push(second);
    }
    void ADD() {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(first+second);
    }
    void SUB() {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second-first);
    }
    void MUL() {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second*first);
    }
    void DIV() {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second/first);
    }
    void MOD() {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second%first);
    }
}
