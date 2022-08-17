package week3.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3425_고스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        exe:while(true) {
            List<String> operators = new LinkedList<String>();
            while(true) {
                String op = br.readLine();
                if(op.equals("QUIT")) {
                    break exe;
                }
                if(op.equals("END")) {
                    break;
                }
                else {
                    operators.add(op);
                }
            }

            int opSize = operators.size();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                Long num = Long.parseLong(br.readLine());
                List<Long> stack = new LinkedList<Long>();
                stack.add(num);
                boolean err = false;
                for(int i=0;i<opSize;i++) {
                    // 연산자 시작
                    st = new StringTokenizer(operators.get(i));
                    String op = st.nextToken();
                    if(op.equals("NUM")) {
                        Long x = Long.parseLong(st.nextToken());
                        stack.add(x);
                    }else if(op.equals("POP")) {
                        if(stack.size()<1) {
                            err = true;
                            break;
                        }
                        stack.remove(stack.size()-1);
                    }else if(op.equals("INV")) {
                        if(stack.size()<1) {
                            err = true;
                            break;
                        }
                        Long nownum = stack.get(stack.size()-1);
                        stack.remove(stack.size()-1);
                        stack.add(nownum*(-1));
                    }else if(op.equals("DUP")) {
                        if(stack.size()<1) {
                            err = true;
                            break;
                        }
                        Long nownum = stack.get(stack.size()-1);
                        stack.add(nownum);
                    }else if(op.equals("SWP")) {
                        if(stack.size()<2) {
                            err = true;
                            break;
                        }
                        Long first = stack.get(stack.size()-1);
                        Long second = stack.get(stack.size()-2);
                        stack.remove(stack.size()-1);
                        stack.remove(stack.size()-1);
                        stack.add(first);
                        stack.add(second);
                    }else if(op.equals("ADD")) {
                        if(stack.size()<2) {
                            err = true;
                            break;
                        }
                        long first = stack.get(stack.size()-1);
                        long second = stack.get(stack.size()-2);
                        if(Math.abs(second+first) > 1000000000) {
                            err = true;
                            break;
                        }
                        stack.remove(stack.size()-1);
                        stack.remove(stack.size()-1);
                        stack.add(first+second);
                    }else if(op.equals("SUB")) {
                        if(stack.size()<2) {
                            err = true;
                            break;
                        }
                        long first = stack.get(stack.size()-1);
                        long second = stack.get(stack.size()-2);
                        if(Math.abs(second-first) > 1000000000) {
                            err = true;
                            break;
                        }
                        stack.remove(stack.size()-1);
                        stack.remove(stack.size()-1);
                        stack.add(second-first);
                    }else if(op.equals("MUL")) {
                        if(stack.size()<2) {
                            err = true;
                            break;
                        }
                        long first = stack.get(stack.size()-1);
                        long second = stack.get(stack.size()-2);
                        stack.remove(stack.size()-1);
                        stack.remove(stack.size()-1);
                        if(Math.abs(second*first) > 1000000000) {
                            err = true;
                            break;
                        }
                        stack.add(second*first);
                    }else if(op.equals("DIV")) {
                        if(stack.size()<2) {
                            err = true;
                            break;
                        }
                        Long first = stack.get(stack.size()-1);
                        Long second = stack.get(stack.size()-2);
                        if(first == 0) {
                            err = true;
                            break;
                        }
                        stack.remove(stack.size()-1);
                        stack.remove(stack.size()-1);
                        stack.add(second/first);
                    }else if(op.equals("MOD")) {
                        if(stack.size()<2) {
                            err = true;
                            break;
                        }
                        Long first = stack.get(stack.size()-1);
                        Long second = stack.get(stack.size()-2);
                        if(first == 0) {
                            err = true;
                            break;
                        }
                        stack.remove(stack.size()-1);
                        stack.remove(stack.size()-1);
                        stack.add(second%first);
                    }
                }
                if(stack.size()>1 || stack.size()==0 ) err = true;
                if(err) {
                    sb.append("ERROR").append("\n");
                }else {
                    sb.append(stack.get(0)).append("\n");
                }
            }
            st = new StringTokenizer(br.readLine());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}