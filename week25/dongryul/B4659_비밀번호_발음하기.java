package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B4659_비밀번호_발음하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = br.readLine();
            if(input.equals("end")) return;

            // 1. 모음(a,e,i,o,u)를 하나 반드시 포함해야 한다.
            boolean b1 = check1(input.toCharArray());

            // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            boolean b2 = check2(input.toCharArray());
            // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo 를 허용

            boolean b3 = check3(input.toCharArray());

            if (b1 && b2 && b3){
                System.out.printf("<%s> is acceptable.\n", input);
            }else{
                System.out.printf("<%s> is not acceptable.\n", input);
            }
        }
    }
    public static boolean check1(char[] input){
        for(int i=0; i<input.length; i++){
            if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') return true;
        }
        return false;
    }
    public static boolean check2(char[] input){
        if(input.length < 3) return true;
        for(int i=0; i<input.length-2; i++){
            char first = input[i];
            char second = input[i+1];
            char third = input[i+2];

            if(isVowel(first) && isVowel(second) && isVowel(third)){
                //연속 세개가 모음??
                return false;
            }
            if(!isVowel(first) && !isVowel(second) && !isVowel(third)){
                // 연속 세개가 자음??
                return false;
            }
        }
        return true;
    }
    public static boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
    public static boolean check3(char[] input){
        if(input.length == 1) return true;
        for(int i=0; i<input.length-1; i++){
            // ee 허용
            if(input[i] == 'e' && input[i+1] == 'e'){
                continue;
            }
            // oo 허용
            else if(input[i] == 'o' && input[i+1] == 'o'){
                continue;
            }else if(input[i] == input[i+1]) return false;
        }
        return true;
    }
}
