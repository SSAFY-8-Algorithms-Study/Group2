package week25;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B12919_A와B2 {
    /**
     *  input 을 output으로 == 시간초과 2^50
     *  output 을 input으로
     *  뒤집고 B를 떼라.
     *  맨 앞이 B여야 뒤집는 것.
     *
     */
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String output = br.readLine();

        answer = 0;
        dfs(output, input);
        System.out.println(answer);
    }
    static void dfs(String output, String input){
        if(output.length() == input.length()){
            if(output.equals(input)){
                answer = 1;
            }
            return;
        }
        if(output.charAt(output.length()-1) == 'A'){
            // A인 경우
            dfs(output.substring(0, output.length()-1), input);
        }

        //맨 앞이 B일 경우는 B를 붙이고 뒤집는 경우가 있을 수 있음
        if(output.charAt(0) == 'B') {
            // 뒤집고
            output = new StringBuilder().append(output).reverse().toString();

            // A, B를 떼라
            dfs(output.substring(0, output.length()-1), input);
        }
    }
}
